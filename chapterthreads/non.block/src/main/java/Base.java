import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;
@Data
public class Base {

    private int id;
    private String title;
    @EqualsAndHashCode.Exclude
    private volatile int version;

    public Base(int sId, String sTitle) {
        this.title = sTitle;
        this.id = sId;
    }

    public void update() {
        this.version++;
    }
}
