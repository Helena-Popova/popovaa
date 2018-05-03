package telephone;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person men : persons) {
            if (men.contains(key)) {
                result.add(men);
            }
        }
        return result;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
