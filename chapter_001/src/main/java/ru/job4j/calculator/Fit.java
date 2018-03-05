package ru.job4j.calculator;

/**
 * Идеальный вес
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */
public class Fit {

    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double manWeight(double height) {
        return (height - 100)*1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double womanWeight(double height) {
        return (height - 110)*1.15;
    }
}