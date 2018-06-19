package containers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> queue = new SimpleQueue();

    @Before
    public void setUp() {
        int i = 0;
        while (i < 4) {
            queue.push(i);
            i++;
        }
    }

    @Test(expected = NullPointerException.class)
    public void poll() {
        assertThat(0, is(queue.poll()));
        assertThat(1, is(queue.poll()));
        assertThat(2, is(queue.poll()));
        assertThat(3, is(queue.poll()));
        queue.poll();
    }

}