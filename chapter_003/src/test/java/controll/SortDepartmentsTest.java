package controll;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SortDepartmentsTest {

    SortDepartments sortDepartments = new SortDepartments();

    @Test
    public void sortInDecreasingOrder() {
        String[] result = sortDepartments.getSortDecrease(new String[] {
                "K1\\SK1",

                "K1\\SK2",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2"});
        assertThat(result, is(new String[] {
                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2",

                "K1",

                "K1\\SK1",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K1\\SK2"}));

    }

    @Test
    public void sortInIncreasingOrder() {
        String[] result = sortDepartments.getSortIncrease(new String[]{
                "K1\\SK1",

                "K1\\SK2",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2"});
        assertThat(result, is(new String[]{

                "K1",

                "K1\\SK1",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K1\\SK2",

                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2"}));

    }


    @Test
    public void sortSimpleSort() {
        String[] result = sortDepartments.getSort(new String[]{
                "K1\\SK1",

                "K1\\SK2",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2"});
        assertThat(result, is(new String[]{

                "K1",

                "K1\\SK1",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K1\\SK2",

                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2"}));

    }

    @Test
    public void sortSimpleSortInDecreasing() {
        String[] result = sortDepartments.getSortReverse(new String[]{
                "K1\\SK1",

                "K1\\SK2",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2"});
        assertThat(result, is(new String[]{
                "K2",

                "K2\\SK1\\SSK1",

                "K2\\SK1\\SSK2",

                "K1",

                "K1\\SK1",

                "K1\\SK1\\SSK1",

                "K1\\SK1\\SSK2",

                "K1\\SK2"}));

    }


}