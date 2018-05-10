package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTestComparator {
    SortUser sortUser = new SortUser();
    List<User> users = new ArrayList<>();

    @Before
    public void loadBefore() {
        users.add(new User("Gulchitay", 23));
        users.add(new User("Poll", 3));
        users.add(new User("Masha", 114));
        users.add(new User("Masha", 24));
    }

    @Test
    public void sortNameLengthTest() {
        Iterator<User> iterator = sortUser.sortNameLength(users).iterator();
        assertThat(iterator.next(), is(new User("Poll", 3)));
        assertThat(iterator.next(), is(new User("Masha", 114)));
        assertThat(iterator.next(), is(new User("Masha", 24)));
        assertThat(iterator.next(), is(new User("Gulchitay", 23)));
    }

    @Test
    public void sortByAllFieldsTest() {
        List<User> result = sortUser.sortByAllFields(users);
        Iterator<User> iterator = result.iterator();

        assertThat(iterator.next(), is(new User("Gulchitay", 23)));
        assertThat(iterator.next(), is(new User("Masha", 24)));
        assertThat(iterator.next(), is(new User("Masha", 114)));
        assertThat(iterator.next(), is(new User("Poll", 3)));
    }

    @Test
    public void sortByAllFieldsBy2MethodTest() {
        List<User> result = sortUser.sortByAllFieldsBy2Method(users);
        Iterator<User> iterator = result.iterator();
        assertThat(iterator.next(), is(new User("Gulchitay", 23)));
        assertThat(iterator.next(), is(new User("Masha", 24)));
        assertThat(iterator.next(), is(new User("Masha", 114)));
        assertThat(iterator.next(), is(new User("Poll", 3)));
    }
}