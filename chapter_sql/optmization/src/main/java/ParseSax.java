import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Обработка данных из XML файла.
 */
public class ParseSax extends DefaultHandler {
    /**
     * @param ENTRY xml attribute
     */
    private static final String ENTRY = "entry";
    /**
     * @param result result
     */
    private int result = 0;


    @Override
    public void startDocument() throws SAXException {
        this.result = 0;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (ENTRY.equalsIgnoreCase(qName)) {
            result = result + Integer.valueOf(attributes.getValue(0));
        }
    }


    public int getResult() {
        return result;
    }
}
