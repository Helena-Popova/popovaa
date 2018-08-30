
import xml.elements.Entry;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;


public class Magnit {

    public static void main(String[] args) throws Exception {
        new File("./target/db").mkdirs();
        String fileName = "./target/db/storesql.db";
        int n = Integer.parseInt(args[0]);
        Config config = new Config(fileName);
        StoreSQL store = new StoreSQL(config);
        store.generate(n);
        List<Entry> entries = store.getAll();

        File storeXML = new File("./sourse.xml");
        new StoreXML(storeXML).save(entries);

        File destXML = new File("./dest.xml");
        File scheme = new File("./convert.xsl");
        new ConvertXSQT().convert(storeXML, destXML, scheme);

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        ParseSax sum = new ParseSax();
        saxParser.parse(destXML, sum);
    }
}
