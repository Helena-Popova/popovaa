package ru.job4j.calculator;

/**
 * Конвентор валюты.
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */
public  class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(int value) {
        Calculator some_value = new Calculator();
        some_value.div(value , 70 );
        return some_value.getResult();
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры
     */
    public double rubleToDollar(int value) {
        Calculator some_value = new Calculator();
        some_value.div(value , 60 );
        return some_value.getResult();
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли
     */
    public double dollarToRubles(int value) {
        Calculator some_value = new Calculator();
        some_value.multiple(value , 60 );
        return some_value.getResult();
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public double euroToRubles(int value) {
        Calculator some_value = new Calculator();
        some_value.multiple(value , 70 );
        return some_value.getResult();
    }

}