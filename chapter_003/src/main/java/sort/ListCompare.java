package sort;

import java.util.Comparator;

/**
 * Компаратор для строк. [#35008]
 */

public class ListCompare implements Comparator<String> {
    /**
     * Компаратор для строк. [#35008]
     * @param o1 первая строка
     * @param o2 строка с которой сравивают
     * @return 0 - равны, меньше 0 - в лексеграфическом парядке какая-то буква была младшего ранга
     * или строка о1 меньше строки 02 по длине,
     * больше 0 - в лексеграфическом порядке буква старшего ранга
     * или строка о1 больше строки 02 по длине
     */
    @Override
    public int compare(String o1, String o2) {
        char[] v1 = o1.toCharArray();
        char[] v2 = o2.toCharArray();
        int lim = Math.min(v1.length, v2.length);
        int result = 0;
        for (int k = 0; k < lim; k++) {
            if (o1.charAt(k) != o2.charAt(k)) {
                result = Integer.compare(o1.charAt(k), o2.charAt(k));
                break;
            }
        }
        if (result == 0 && o1.length() != o2.length()) {
            result = Integer.compare(o1.length(), o2.length());
        }
        return result;
    }
}
