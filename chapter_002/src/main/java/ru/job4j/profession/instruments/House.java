package ru.job4j.profession.instruments;

/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */
public class House {
    private double length, height, width, cost;

    /**
     *
     * @param aLength длина
     * @param aHeight высота
     * @param aWidth ширина
     * @param aCost стоимость дома
     */
    public House(double aLength, double aHeight, double aWidth, double aCost) {
        this.length = aLength;
        this.height = aHeight;
        this.width = aWidth;
        this.cost = aCost;
    }

    /**
     * Oбьем дома.
     * @return double
     */
    public double getAmount() {
        return this.length * this.width * this.height;
    }

    /**
     * Необходимые затраты на дом.
     * @return double
     */
    public double getCost() {
        return this.cost;
    }
}
