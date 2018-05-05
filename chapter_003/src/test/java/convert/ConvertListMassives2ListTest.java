package convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Helena
 */
public class ConvertListMassives2ListTest {

    ConvertList2Array convertListMassives = new ConvertList2Array();

    /**
     * Добавляем непустые массивы и в результате видим список со значениями из массивов
     */
    @Test
    public void convertTest() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertListMassives.convert(list);
        assertThat(new Integer[]{1, 2, 3, 4, 5, 6}, is(result.toArray(new Integer[list.size()])));
    }

    /**
     * добавляем пустые массивы, в рузультате список пустой
     */
    @Test
    public void convertEmptyMassToList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{});
        list.add(new int[]{});
        List<Integer> result = convertListMassives.convert(list);
        assertThat(true, is(result.isEmpty()));
    }
}