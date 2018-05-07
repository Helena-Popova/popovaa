package transformations;

import java.util.Objects;

/**
 * @author Helena
 */
public class User {
    private Integer id;
    private String name;
    private String sity;

    public User(Integer id, String name, String sity) {
        this.id = id;
        this.name = name;
        this.sity = sity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(name, user.name)
                && Objects.equals(sity, user.sity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sity);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSity() {
        return sity;
    }
}
