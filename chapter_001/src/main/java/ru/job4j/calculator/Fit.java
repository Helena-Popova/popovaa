package ru.job4j.calculator;

/**
 * Идеальный вес
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */
public class Fit {

    public static final double I_W_RATIO = 1.15;
    public static final double I_W_COEF_MEN = 100;
    public static final double I_W_COEF_WMEN = 110;
    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double manWeight(double height) {
        return (height - I_W_COEF_MEN)*I_W_RATIO;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double womanWeight(double height) {
        return (height - I_W_COEF_WMEN)*I_W_RATIO;
    }
}