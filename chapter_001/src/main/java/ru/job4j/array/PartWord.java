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
        int a = 0;

        for (int index = 0; index < origin.length(); index++) {
                if (data[index] == part[a]) {
                    a++;
                    if (a == sub.length() - 1) {
                        return true;
                    }
                }
                else if (a != 0) {
                    index--;
                    a = 0;
                }
        }
        return  false;
    }


}
