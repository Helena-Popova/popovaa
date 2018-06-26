import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedSetTest {
    SimpleLinkedSet<Integer> linkedSet = new SimpleLinkedSet();

    @Before
    public void setUp() {
        int i = 0;
        while (i < 10) {
            linkedSet.add(i);
            i++;
        }
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        int size = linkedSet.getSize();
        linkedSet.add(1);
        assertThat(size, is(linkedSet.getSize()));
        linkedSet.add(2);
        assertThat(size, is(linkedSet.getSize()));
        linkedSet.add(5);
        assertThat(size, is(linkedSet.getSize()));
        linkedSet.add(11);
        assertThat(size + 1, is(linkedSet.getSize()));
        assertThat(linkedSet.get(0), is(0));
        assertThat(linkedSet.get(5), is(5));
        assertThat(linkedSet.get(9), is(9));
        assertThat(linkedSet.get(10), is(11));
    }

}