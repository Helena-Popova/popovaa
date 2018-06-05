package ru.job4j.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двухмерного массива int[][]
 */

public class IteratorForTwoDimensionalArray implements Iterator {


    private int[] sourse;
    private int index = 0;
    private int limit = 0;

    public IteratorForTwoDimensionalArray(int[][] aSource) {
        Arrays.stream(aSource).forEach(mass -> limit += mass.length);
        sourse = new int[limit];
        for (int[] str : aSource) {
            System.arraycopy(str, 0, sourse, index, str.length);
            index += str.length;
        }
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < limit;
    }

    @Override
    public Object next() {
        if (index >= limit) {
            throw new NoSuchElementException();
        }
        return sourse[index++];
    }
}
