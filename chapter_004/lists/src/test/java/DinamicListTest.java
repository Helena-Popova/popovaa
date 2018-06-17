import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DinamicListTest {
    DinamicList<Integer> dinamicList = new DinamicList();

    @Before
    public void setUp() {
        int i = 0;
        while (i < 10) {
            dinamicList.add(i);
            i++;
        }
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(dinamicList.get(0), is(0));
        assertThat(dinamicList.get(5), is(5));
        assertThat(dinamicList.get(9), is(9));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        Iterator<Integer> integerIterator = dinamicList.iterator();
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(0, is(dinamicList.get(0)));
        assertThat(1, is(dinamicList.get(1)));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnEvenNumbersSequentially() {
        Iterator<Integer> integerIterator = dinamicList.iterator();
        Iterator<Integer> integerIterator1 = dinamicList.iterator();
        assertTrue(integerIterator.hasNext());
        assertTrue(integerIterator1.hasNext());
        integerIterator.remove();
        integerIterator1.hasNext();

    }
}