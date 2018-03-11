package ru.job4j.calculator;

/**
 * Идеальный вес
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */
public class Fit {

    public static final double IWRATIO = 1.15;
    public static final double COEFMEN = 100;
    public static final double COEFWMEN = 110;
    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double manWeight(double height) {
        return (height - COEFMEN) * IWRATIO;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double womanWeight(double height) {
        return (height - COEFWMEN) * IWRATIO;
    }
}