import xml.elements.Entries;
import xml.elements.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;

/**
 * Генерация XML из данных базы. Описывается класс StoreXML
 * StoreXML(File target) - target - Файл куда будет сохраняться данные.
 */
public class StoreXML {
    /** Файл, куда будут сохраняться данные */
    private File target;

    StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) throws Exception {
        Entries entries = new Entries(list);
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(entries, this.target);
    }
}
