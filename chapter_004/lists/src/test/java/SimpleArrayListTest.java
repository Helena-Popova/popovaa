import lists.SimpleArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {
    SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList();

    @Before
    public void setUp() {
        simpleArrayList.add(1);
        simpleArrayList.add(2);
        simpleArrayList.add(3);
        simpleArrayList.add(4);
        simpleArrayList.add(5);
        simpleArrayList.add(6);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleArrayList.get(1), is(2));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        simpleArrayList.delete();
        assertThat(Integer.valueOf(2), is(simpleArrayList.get(0)));
        assertThat(Integer.valueOf(1), is(simpleArrayList.get(1)));
        assertThat(simpleArrayList.getSize(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteAllElementsThanGetEmptyArray() {
        assertThat(6, is(simpleArrayList.get(0)));
        assertThat(6, is(simpleArrayList.delete()));
        assertThat(5, is(simpleArrayList.get(0)));
        assertThat(simpleArrayList.getSize(), is(5));
        assertThat(5, is(simpleArrayList.delete()));
        assertThat(4, is(simpleArrayList.get(0)));
        assertThat(simpleArrayList.getSize(), is(4));
        assertThat(4, is(simpleArrayList.delete()));
        assertThat(3, is(simpleArrayList.get(0)));
        assertThat(simpleArrayList.getSize(), is(3));
        assertThat(3, is(simpleArrayList.delete()));
        assertThat(2, is(simpleArrayList.get(0)));
        assertThat(simpleArrayList.getSize(), is(2));
        assertThat(2, is(simpleArrayList.delete()));
        assertThat(1, is(simpleArrayList.get(0)));
        assertThat(simpleArrayList.getSize(), is(1));
        assertThat(1, is(simpleArrayList.delete()));
        simpleArrayList.get(0);
    }
}