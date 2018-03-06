package ru.job4j.calculator;

/**
 * Конвентор валюты.
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */
public  class Converter {
    /**
     * закрытые поля для  EuroRate и DollarRate
     */
    private final int EURO_RATE = 70;
    private final int DOLLAR_RATE = 60;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(int value) {
        Calculator some_value = new Calculator();
        some_value.div(value , EURO_RATE );
        return some_value.getResult();
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры
     */
    public double rubleToDollar(int value) {
        Calculator some_value = new Calculator();
        some_value.div(value , DOLLAR_RATE );
        return some_value.getResult();
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли
     */
    public double dollarToRubles(int value) {
        Calculator some_value = new Calculator();
        some_value.multiple(value , DOLLAR_RATE );
        return some_value.getResult();
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public double euroToRubles(int value) {
        Calculator some_value = new Calculator();
        some_value.multiple(value , EURO_RATE );
        return some_value.getResult();
    }

}