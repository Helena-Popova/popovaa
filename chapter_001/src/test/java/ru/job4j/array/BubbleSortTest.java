package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void whenSortMassiv() {
        int[] myArrayForSort = {9, 8, 13, 6, 5, 4, 0, 2, 1};
        BubbleSort someSort = new BubbleSort();
        int[] result = someSort.sort(myArrayForSort);
        assertThat(result, is(new int[] {0, 1, 2, 4, 5, 6, 8, 9, 13}));
    }

}