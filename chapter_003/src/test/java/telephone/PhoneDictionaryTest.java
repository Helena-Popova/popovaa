package telephone;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next(), is(new Person("Petr", "Arsentev", "534872", "Bryansk")));
    }

    @Test
    public void whenAddPerson() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person(null, null, null, null));
        assertThat(phones.getPersons().iterator().next(), is(new Person(null, null, null, null)));
    }

}