package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Helena
 * @version 1.0
 * @since 15.03.18
 */

public class SortMass {

    public int[] sort(int[] massFirst, int[] massSecond) {

        int[] massSort = new int[massFirst.length + massSecond.length];
        int a = 0;
        int i = 0;

        for (int counter = 0; counter < massSort.length; counter++) {
            if (!(i < massSecond.length) || a < massFirst.length && massFirst[a] < massSecond[i]) {
                massSort[counter] = massFirst[a++];
            } else {
                massSort[counter] = massSecond[i++];
            }
        }
        return massSort;
    }
}

