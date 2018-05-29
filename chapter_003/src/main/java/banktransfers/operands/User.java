package banktransfers.operands;

import java.util.Objects;

public class User {
    private String name;
    private String passport;

    public static final User EMPTY = new User();

    public User() {
        this.name = "indefined";
        this.passport = "indefined";
    }

    public User(String passport) {
        this.name = "TO DO";
        this.passport = passport;
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, passport);
    }
}
