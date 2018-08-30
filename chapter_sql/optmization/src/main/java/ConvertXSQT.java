import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertXSQT {
    private static final Logger LOG = Logger.getLogger(StoreSQL.class.getName());
    /**
     * Преобразовать полученный файл из пункта 3 в файл другого XML формата через XSTL.
     * Этот процесс будет описываться классом - ConvertXSQT
     * Метод convert(File source, File dest, File scheme) -
     * читает файл source и преобразовывает его в файл dest за счет XSTL схемы scheme.
     * @param source
     * @param dest
     * @param scheme
     */
    public void convert(File source, File dest, File scheme) {
        try {
            Source sScheme = new StreamSource(new FileInputStream(scheme));
            Source sSource = new StreamSource(new FileInputStream(source));
            Result rDest = new StreamResult(new FileOutputStream(dest));
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(sScheme);
            transformer.transform(sSource, rDest);
        } catch (FileNotFoundException | TransformerException e) {
            LOG.log(Level.WARNING, "XSLT error", e);
        }
    }
}
