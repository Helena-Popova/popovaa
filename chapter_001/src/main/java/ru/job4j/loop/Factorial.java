package ru.job4j.loop;

/**
 * It is class for calculate of some factorial
 * @author HelenaPopova
 * @version 1.0
 * @since 06.03.18
 */

public class Factorial {

    /**
     * Method calculate
     * @param n
     * @return resultCalculate of Factorial
     */
    public int calc(int n){
        int resultCalculate = 1;
        while(n > 1){
            resultCalculate *= n--;
        }
        return resultCalculate;
    }
}
