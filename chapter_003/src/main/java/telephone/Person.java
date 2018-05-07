package telephone;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String adress;

    public Person(String name, String surname, String phone, String adress) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (getClass() == o.getClass() && o != null) {
            Person person = (Person) o;
            result = Objects.equals(name, person.name)
                    && Objects.equals(surname, person.surname)
                    && Objects.equals(phone, person.phone)
                    && Objects.equals(adress, person.adress);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone, adress);
    }

    public boolean contains(String key) {
        return this.adress.contains(key) || this.name.contains(key) || this.phone.contains(key) || this.surname.contains(key);
    }
}
