package xml.elements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class Entries {
    private List<Entry> entries;

    public Entries() {
    }

    public Entries(List<Entry> entry) {
        this.entries = entry;
    }

    @XmlElement(name = "entry")
    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        Entries entries1 = (Entries) o;
        return Objects.equals(entries, entries1.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entries);
    }
}
