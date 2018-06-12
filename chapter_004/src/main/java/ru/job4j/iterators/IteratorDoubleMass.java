package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.2. Создать итератор четные числа [#150]
 */

public class IteratorDoubleMass implements Iterator {

    private int[][] source;
    private int index = 0;

    public IteratorDoubleMass(int[][] aSource) {
        source = aSource;
    }

    @Override
    public boolean hasNext() {
        return fintElement() != null;
    }

    @Override
    public Object next() {
        Integer result = fintElement();
        if (result == null) {
            throw new NoSuchElementException();
        }
        index++;
        return result;
    }

    private Integer fintElement() {
        Integer result = null;
        int count = 0;
        for (int[] mass : source) {
            for (int i : mass) {
                if (index == count) {
                    result = i;
                }
                count++;
            }
        }
        return result;
    }
}
