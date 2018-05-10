package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenSortSomeUsersListByAge() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Gulchitay", 23));
        users.add(new User("Petya", 3));
        users.add(new User("Masha", 14));
        Set<User> result =  sortUser.sort(users);
        assertThat(result.iterator().next(), is(new User("Petya", 3)));

    }

}