package ru.job4j.array;

/**
 * Проверка, что одно слово находится в другом слове.
 * @author Helena
 * @version 1.0
 * @since 14.03.18
 */

public class PartWord {

    /**
     * Ищет последовательность в слове
     * @param origin
     * @param sub
     * @return
     */
    public boolean contains(String origin, String sub) {

        char[] data = origin.toCharArray();
        char[] part = sub.toCharArray();
        int counter = 0;

        for (int index = 0; index < origin.length(); index++) {
                if (data[index] == part[counter]) {
                    counter++;
                    if (counter == sub.length() - 1) {
                        return true;
                    }
                }
                else if (counter != 0) {
                    index--;
                    counter = 0;
                }
        }
        return  false;
    }


}
