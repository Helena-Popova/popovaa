package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt implements Iterator {
    private  int[] source;
    private int index = 0;

    public EventIt(int[] sourseS) {
        this.source = sourseS;

    }

    /**
     * Проходимся по массиву от index , ищем последующие четные числа
     * @return есть ли четное число или нет
     */
    @Override
    public boolean hasNext() {
        int temp = 0;
        while (index + temp < source.length) {
            if (source[index + temp] % 2 == 0) {
                index = index + temp;
                return true;
            }
            temp++;
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return source[index++];
    }
}

