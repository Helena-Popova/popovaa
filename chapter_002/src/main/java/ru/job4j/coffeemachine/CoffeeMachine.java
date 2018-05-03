package ru.job4j.coffeemachine;

import ru.job4j.coffeemachine.exceptions.ValueError;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    /**
     * проверка на правильность ввода данных
     * @param value купюра пользователя
     * @param price цена товара
     */
    private void exceptionChecked(int value, int price) {
        if (price < 0 || value < 0) {
            throw new ValueError("Неверно указана цена товара");
        } else if (value < price) {
            throw new ValueError("Недостаточно денег для выдачи кофе");
        }
    }

    /**
     * Считает сдачу
     * @param value купюра
     * @param price цена товара
     * @return массив с обозначением номинала монеток в сдаче от больших к меньшим
     */
    public int[] changes(int value, int price) {
        exceptionChecked(value, price);

        List<Integer> changeList = new ArrayList<>();
        int temp = value - price;
        int coin = 10;
        while (temp > 0) {
            temp -= coin;
            if (temp >= 0) {
                changeList.add(coin);
            } else {
                temp += coin;
                coin = (int) Math.floor(coin / 2.0);
            }
        }
        int[] change = new int[changeList.size()];
        for (int i = 0; i < changeList.size(); i++) {
            change[i] = changeList.get(i);
        }
        return change;
    }
}
