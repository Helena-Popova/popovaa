import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    SimpleSet<Integer> simpleSet = new SimpleSet();

    @Before
    public void setUp() {
        simpleSet.add(0);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);

    }
    @Test
    public void whenAddNumbersReturnTrueIfNumberIsNotExist() {
        assertThat(simpleSet.add(5), is(true));
        assertThat(simpleSet.add(1), is(false));
        assertThat(simpleSet.add(2), is(false));
        assertThat(simpleSet.add(3), is(false));
    }

    @Test
    public void whenReturnGetNumberByIndex() {
        assertThat(simpleSet.get(0), is(0));
        assertThat(simpleSet.get(1), is(1));
        assertThat(simpleSet.get(2), is(2));
        assertThat(simpleSet.get(3), is(3));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        Iterator<Integer> integerIterator = simpleSet.iterator();
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(0, is(simpleSet.get(0)));
        assertThat(1, is(simpleSet.get(1)));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnEvenNumbersSequentially() {
        Iterator<Integer> integerIterator = simpleSet.iterator();
        Iterator<Integer> integerIterator1 = simpleSet.iterator();
        assertTrue(integerIterator.hasNext());
        assertTrue(integerIterator1.hasNext());
        integerIterator.remove();
        integerIterator1.hasNext();

    }
}