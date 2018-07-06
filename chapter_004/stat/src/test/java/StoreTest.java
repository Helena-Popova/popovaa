import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreTest {
    Store store = new Store();
    List<User> one = new ArrayList<>();
    List<User> two = new ArrayList<>();

    @Before
    public void  loadBefore() {
        int id = 0;
        one = Arrays.asList(
                new User(id++, "name for " + String.valueOf(id)),
                new User(id++, "name for " + String.valueOf(id)),
                new User(id++, "name for " + String.valueOf(id)),
                new User(id + 5, "name for " + String.valueOf(id)));
        id = 0;
        two = Arrays.asList(
                new User(id++, "new name for " + String.valueOf(id)),
                new User(id++, "name for " + String.valueOf(id)),
                new User(id++, "name for " + String.valueOf(id)),
                new User(id++, "name for " + String.valueOf(id)));
    }

    @Test
    public void returnNumbersNewElementsInList() {
        assertThat(1, is(store.diff(one, two).getNumberNew()));
    }

    @Test
    public void returnNumbersAddedElementsInList() {
        assertThat(1, is(store.diff(one, two).getNumberAdded()));
    }

    @Test
    public void returnNumbersDeletedElementsInList() {
        assertThat(1, is(store.diff(one, two).getNumberDeleted()));
    }
}