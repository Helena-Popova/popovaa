package ru.job4j.loop;

/**
 * It is class for calculate of some factorial
 * @author HelenaPopova
 * @version 1.0
 * @since 06.03.18
 */

public class Factorial {

    /**
     * Method calculate.
     * @param n
     * @return result calculate of Factorial
     */
    public int calc(int n) {
        int result = 1;
        while (n > 1) {
            result *= n--;
        }
        return result;
    }
}
