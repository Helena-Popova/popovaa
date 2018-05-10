package convert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Конвертация двумерного массива в ArrayList
 * @author Helena
 */
public class ConvertArray2List {

    /**
     * Конвертация двумерного массива в ArrayList
     * @param array входящий массив для конвертации
     * @return список со значениями из массива
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] mass : array) {
            list.addAll(Arrays.stream(mass).boxed().collect(Collectors.toList()));
        }
        return list;
    }

    /**
     * Конвертация двумерного массива в ArrayList в два цикла
     * @param array
     * @return
     */
    public List<Integer> toListbyForeach(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] mass : array) {
            for (int step : mass) {
                list.add(step);
            }
        }
        return list;
    }
}
