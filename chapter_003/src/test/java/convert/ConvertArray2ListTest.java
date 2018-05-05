package convert;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertArray2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertArray2List list = new ConvertArray2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayIsEmptyThenListIsEmpty() {
        ConvertArray2List list = new ConvertArray2List();
        int[][] input = {};
        List<Integer> expect = Arrays.asList();
        List<Integer> result = list.toList(input);
        assertThat(expect.isEmpty(), is(result.isEmpty()));
    }
}