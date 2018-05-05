package convert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * метод toArray должен равномерно разбить лист на количество строк двумерного массива.
 * В методе toArray должна быть проверка - если количество элементов не кратно количеству строк -
 * оставшиеся значения в массиве заполнять нулями.
 * @author Helena
 */
public class ConvertList2Array {
    /**
     * Конвертация с помощью одного цикла
     * @param list входящий список
     * @param rows число строк
     * @return двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] result = new int[rows][cells];
        for (int step = 0; step < rows; step++) {
            int finish = step * cells + cells < list.size() ? step * cells + cells : list.size();
            List<Integer> temp = step * cells < list.size() ? list.subList(step * cells, finish) : new ArrayList<Integer>(cells);
            result[step] = Arrays.copyOf(temp.stream().mapToInt(Integer::intValue).toArray(), cells);
        }
        return result;
    }

    /**
     * Конвертация с помощью двух циклов с использованием Foreach
     * @param list входящий список
     * @param rows число строк
     * @return двумерный массив
     */
    public int[][] toArrayByForeach(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] result = new int[rows][cells];
        int index = 0;
        for (int[] mass : result) {
            for (int step = 0; step < cells; step++) {
                mass[step] = index < list.size() ? list.get(index) : 0;
                index++;
            }
        }
        return result;
    }

    /**
     * Конвертация листа массивов в один лист Integer
     * @param list
     * @return
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] mass : list) {
            result.addAll(Arrays.stream(mass).boxed().collect(Collectors.toList()));
        }
        return result;
    }

}
