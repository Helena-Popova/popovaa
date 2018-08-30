package implement;

import helper.PagePosition;
import helper.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sql.ConnectDB;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class PageParser implements Job {
    private List<Vacancy> positions = new ArrayList<>();
    private Date floorDate;

    private final Properties properties = ParserMain.loadProperties();

    /**
     * коннектиться с базой , выгружает вакансии и записывает из в базу данных
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try (ConnectDB db = new ConnectDB(this.properties)) {
            try {
                db.connect();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Timestamp timestamp = db.getLastTImeInsert();
            this.parsePositions();
            db.insert(this.positions);
        }
    }

    private static Properties loadProperties() {
        Properties result = new Properties();
        try {
            result.load(new FileReader(ParserMain.configuration));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return result;
    }


    /**
     * проходится по страницам и выгружает от туда вакансии
     */
    private void parsePositions() {
        for (int i = 1; i < 100; i++) {
            Document doc;
            try {
                String url = String.format("http://sql.ru/forum/job-offers/%d", i);
                doc = Jsoup.connect(url).get();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
            PagePosition pagePositions = new PagePosition();
            this.positions.addAll(pagePositions.parse(doc, this.floorDate));
            if (pagePositions.floorFound()) {
                break;
            }
        }
    }
}
