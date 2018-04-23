package ru.job4j.coffeemachine;
import ru.job4j.coffeemachine.exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class CoffeeM {

    /**
     * Сдача,которую может выдавать автомат,
     * значения соот-но передаются в конструкторе
     */
    private enum ShortChange {
        /**
         * названия монеток
         */
        TEN(10), FIVE(5), TWO(2), ONE(1);
        private int primitive;
        ShortChange(int i) {
            this.primitive = i;
        }

        /**
         * получить значение монетки
         * @return значение монетки
         */
        int getPrimitive() {
            return this.primitive;
        }

    }

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
     * Считает нам сдачу и возвращает как массив int[], начиная с самого большого значения
     * @param value
     * @param price
     * @return
     */
    public int[] changes(int value, int price) {
        exceptionChecked(value, price);
        System.out.println(value - price);
        List<Integer> changeList = new ArrayList<>();
        int temp = value - price;
        LabelOne : for (ShortChange money : ShortChange.values()) {
            while (temp > 0) {
                temp -= money.getPrimitive();
                if (temp >= 0) {
                    changeList.add(money.getPrimitive());
                }
                if (temp < 0) {
                    temp += money.getPrimitive();
                    continue LabelOne;
                } else if (temp == 0) {
                    break LabelOne;
                }
            }
        }
        int[] change = new int[changeList.size()];
        for (int i = 0; i < changeList.size(); i++) {
            change[i] = changeList.get(i);
        }
        return change;
    }
}
