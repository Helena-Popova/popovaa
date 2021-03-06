package convert;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when0ElementsThenMassIsEmpty() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(),
                0
        );
        int[][] expect = {};
        assertThat(result, is(expect));
    }

    @Test
    public void when3Elementsand3RowsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1),
                3
        );
        int[][] expect = {
                {1},
                {0},
                {0}
        };
        assertThat(result, is(expect));
    }

    /**
     * проверка второго метода toArrayByForeach
     */

    @Test
    public void when7ElementsThen9ByForeach() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArrayByForeach(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen9ByForeach() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArrayByForeach(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen8ByForeach() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArrayByForeach(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when0ElementsThenMassIsEmptyByForeach() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArrayByForeach(
                Arrays.asList(),
                0
        );
        int[][] expect = {};
        assertThat(result, is(expect));
    }

    @Test
    public void when3Elementsand3RowsThen9ByForeach() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArrayByForeach(
                Arrays.asList(1),
                3
        );
        int[][] expect = {
                {1},
                {0},
                {0}
        };
        assertThat(result, is(expect));
    }
}