package ru.job4j.iterators;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IteratorForTwoDimensionalArrayTest {
    IteratorForTwoDimensionalArray iter = new IteratorForTwoDimensionalArray(new int[][]{{1}, {2, 3}, {4, 6, 7}});

    @Test
    public void hasNext() {
        int count = 0;
        while (iter.hasNext()) {
            iter.next();
            count++;
        }
        assertThat(count, is(6));
    }

    @Test
    public void next() {
        iter.next();
        iter.next();
        assertThat(iter.next(), is(3));
    }
}