package ru.job4j.calculator;

/**
 * Конвентор валюты.
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */
public  class Converter {
    /**
     *  поля для  EuroRate и DollarRate
     */
    public static final int EURO = 70;
    public static final int DOLLAR = 60;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(int value) {
        Calculator someValue = new Calculator();
        someValue.div(value, EURO);
        return someValue.getResult();
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры
     */
    public double rubleToDollar(int value) {
        Calculator someValue = new Calculator();
        someValue.div(value, DOLLAR);
        return someValue.getResult();
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли
     */
    public double dollarToRubles(int value) {
        Calculator someValue = new Calculator();
        someValue.multiple(value, DOLLAR);
        return someValue.getResult();
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public double euroToRubles(int value) {
        Calculator someValue = new Calculator();
        someValue.multiple(value, EURO);
        return someValue.getResult();
    }

}