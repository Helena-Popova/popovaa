
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import xml.elements.Entry;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


public class Magnit {
    private ClassLoader classLoader = getClass().getClassLoader();
    File storeXML = new File(getClass().getClassLoader().getResource("source.xml").getFile());
    File destXML = new File(getClass().getClassLoader().getResource("dest.xml").getFile());
    File scheme = new File(getClass().getClassLoader().getResource("convert.xsl").getFile());
    private StoreXML xml;
    /**
     * @param xsqt convert xml
     */
    private ConvertXSQT xsqt = new ConvertXSQT();


    public Magnit() {
        xml = new StoreXML(storeXML);
    }

    /**
     * method init.
     * @param n value for adding in db
     */
    public void init(int n) throws SQLException {
        new File("./target/db").mkdirs();
        String fileName = "./target/db/storesql.db";
        Config config = new Config(fileName);
        StoreSQL db = new StoreSQL(config);
        db.generate(n);
        try {
            xml.save(db.getAll());
            convertXml();
            parseXml();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method for convert xml.
     */
    private void convertXml() {
        xsqt.convert(storeXML, destXML, scheme);
    }

    /**
     * Method for parse xml.
     */
    private void parseXml() throws IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = spf.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        ParseSax sum = new ParseSax();
        try {
            saxParser.parse(destXML, sum);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

