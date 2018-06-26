import lists.DinamicLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DinamicLinkedListTest {
    DinamicLinkedList<Integer> dinamicLinkedList = new DinamicLinkedList();

    @Before
    public void setUp() {
        int i = 0;
        while (i < 100) {
            dinamicLinkedList.add(i);
            i++;
        }
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(dinamicLinkedList.get(0), is(0));
        assertThat(dinamicLinkedList.get(77), is(77));
        assertThat(dinamicLinkedList.get(99), is(99));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        Iterator<Integer> integerIterator = dinamicLinkedList.iterator();
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.hasNext(), is(true));
        integerIterator.next();
        integerIterator.next();
        integerIterator.next();
        integerIterator.remove();
        Iterator<Integer> integerIterator1 = dinamicLinkedList.iterator();
        integerIterator1.next();
        integerIterator1.next();
        integerIterator1.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnEvenNumbersSequentially() {
        Iterator<Integer> integerIterator = dinamicLinkedList.iterator();
        Iterator<Integer> integerIterator1 = dinamicLinkedList.iterator();
        assertTrue(integerIterator.hasNext());
        assertTrue(integerIterator1.hasNext());
        integerIterator.next();
        integerIterator1.next();
        integerIterator.remove();
        integerIterator1.hasNext();

    }
}