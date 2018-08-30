package implement;

import org.quartz.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;

/**
 * 1. Реализовать модуль сборки анализа данных с sql.ru.
 * 2. система должна использовать Jsoup для скачивания страницы.
 * 3. Система должна запускаться раз в день.
 */
public class ParserMain {

    static String configuration = "app.properties";
    static Logger logger;

    public void init(String appConf) throws SchedulerException {

        configuration = appConf;

        System.getProperties().setProperty("app.properties",
                String.format("file:%s", configuration));
        logger = Logger.getLogger(ParserMain.class);
        String time = loadProperties().getProperty("cron.time");
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        //запускается раз в день
        JobDetail job = JobBuilder.newJob(PageParser.class)
                .withIdentity("job1", "group1")
                .build();
        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0 0 12 * * ?"))
                .build();

        sched.scheduleJob(job, trigger);
        sched.start();
    }

    public static void main(String[] args) throws SchedulerException {
        ParserMain parser = new ParserMain();
        parser.init(args.length > 0 ? args[0] : "app.properties");
    }

    public static Properties loadProperties() {
        Properties result = new Properties();
        try {
            result.load(new FileReader(configuration));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return result;
    }
}
