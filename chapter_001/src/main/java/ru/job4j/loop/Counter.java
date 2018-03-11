package ru.job4j.loop;

/**
 * Class for some loop
 * @author Popova A
 * @version 1.0
 * A Long Time Ago in a Galaxy Far, Far Away.
 * @since 1.0
 */

public class Counter {

    /**
     *Method add for class Counter
     * @param start
     * @param finish
     * @return result summ of even numbers
     */
    public int add(int start, int finish) {
        int summ = 0;
        int counter = start;
        while (counter <= finish) {
            if (counter % 2 == 0) {
                summ += counter;
            }
            counter++;
        }
        return summ;
    }
}
