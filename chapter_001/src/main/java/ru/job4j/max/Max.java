package ru.job4j.max;

/**
 * Class for calculate max value from twos numbers.
 *@author Popova Alena
 *@version 1.0
 *@since 06.03.18
 */
public class Max {

    /**
     *Method for calculate .
     *@param firstValue
     *@param secondValue
     * are numders for compare.
     *@result max value
     */
    public int max(int firstValue, int secondValue) {
        return firstValue > secondValue ? firstValue : secondValue;
    }

}
