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
     *@param first
     *@param second
     * are numders for compare.
     *@result max value
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     *
     * @param first
     * @param second
     * @param therd
     * @return max of three values
     */
    public int max(int first, int second, int therd) {
        return this.max(this.max(first, second), therd);
    }

}
