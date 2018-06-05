package ru.job4j.iterators;
import java.util.Iterator;

/**
 * 5.1.2. Создать итератор четные числа [#150]
 */

public class IteratorDoubleMass implements Iterator {

    private int[][] source;
    private int limits = 0;
    private int index = 0;

    public IteratorDoubleMass(int[][] aSource) {
        for (int[] mass : aSource) {
            limits += mass.length;
        }
        source = aSource;
    }

    @Override
    public boolean hasNext() {
        return index < limits;
    }

    @Override
    public Object next() {
        int count = 0;
        for (int[] mass : source) {
            for (int i : mass) {
                if (index == count) {
                    index++;
                    return i;
                }
                count++;
            }
        }
        return null;
    }
}
