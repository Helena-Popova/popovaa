package store;

import base.Role;
import base.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    private RoleStore<Role> roleStore;

    @Before
    public void setUp() {
        roleStore = new RoleStore(12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldReturnExceptionWhetTryAddMoreUsersThanCapacity() {
        int i = 0;
        while (i < 13) {
            roleStore.add(new Role(String.valueOf(i)));
            i++;
        }
    }

    @Test
    public void shouldReturnAllAddingElements() {
        int i = 0;
        while (i < 12) {
            String id = String.valueOf(i);
            roleStore.add(new Role(id));
            assertThat(new Role(id), is(roleStore.findById(id)));
            i++;
        }
    }

    @Test
    public void shouldReturnAllReplacementElements() {
        int i = 0;
        while (i < 5) {
            String id = String.valueOf(i);
            roleStore.add(new Role(id));
            i++;
        }
        assertTrue(roleStore.replace(String.valueOf(1), new Role("New 1")));
        assertTrue(roleStore.replace(String.valueOf(3), new Role("New 2")));
        assertTrue(roleStore.replace(String.valueOf(4), new Role("New 3")));
        assertThat(new Role("New 1"), is(roleStore.findById("New 1")));
        assertThat(new Role("New 2"), is(roleStore.findById("New 2")));
        assertThat(new Role("New 3"), is(roleStore.findById("New 3")));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnArrayWithoutDeletedEletments() {
        int i = 0;
        while (i < 12) {
            String id = String.valueOf(i);
            roleStore.add(new Role(id));
            i++;
        }
        String id = String.valueOf(2);
        assertTrue(roleStore.delete(id));
        roleStore.findById(id);
    }
}