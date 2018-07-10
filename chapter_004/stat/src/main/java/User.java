import java.util.Objects;

import lombok.*;
@EqualsAndHashCode
@ToString
public class User {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
