package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] myFullArray = {"1", "2", "1", "3", "2", "5", "5"};
        ArrayDuplicate duplicateArray = new ArrayDuplicate();
        String[]  result = duplicateArray.remove(myFullArray);
        assertThat(result, is(new String[]{"1", "2", "5", "3"}));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicatewithOneNumbers() {
        String[] myFullArray = {"1", "1", "1", "1", "1", "1", "1"};
        ArrayDuplicate duplicateArray = new ArrayDuplicate();
        String[]  result = duplicateArray.remove(myFullArray);
        assertThat(result, is(new String[]{"1"}));
    }

}