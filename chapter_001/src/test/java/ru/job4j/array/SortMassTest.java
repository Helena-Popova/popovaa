package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortMassTest {

   @Test
    public void whenWeHaveCoupleSortMassThenReturnSortMultiplateMass() {
        int[] first = new int[]{1,6,7};
        int[] second = new int[]{3,5,9,10};
        SortMass massive = new SortMass();
        int[] result = massive.sort(first,second);
        assertThat(result, is(new int[]{1,3,5,6,7,9,10}));

    }

}