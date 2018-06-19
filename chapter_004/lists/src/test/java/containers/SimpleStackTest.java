package containers;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> stack = new SimpleStack();

    @Before
    public void setUp() {
        int i = 0;
        while (i < 10) {
            stack.push(i);
            i++;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void poll() {
        assertThat(9, is(stack.poll()));
        assertThat(8, is(stack.poll()));
        assertThat(7, is(stack.poll()));
        assertThat(6, is(stack.poll()));
        assertThat(5, is(stack.poll()));
        assertThat(4, is(stack.poll()));
        assertThat(3, is(stack.poll()));
        assertThat(2, is(stack.poll()));
        assertThat(1, is(stack.poll()));
        assertThat(0, is(stack.poll()));
        stack.poll();
    }
}