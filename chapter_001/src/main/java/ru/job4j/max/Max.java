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

    /**
     *
     * @param firstValue
     * @param secondValue
     * @param therdValue
     * @return max of three values
     */
    public int max(int firstValue, int secondValue, int therdValue) {
        return this.max(this.max(firstValue,secondValue),therdValue);
    }

}
