package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SquareTest {

    @Test
    public void outSquareArray() {
        Square arraySqare = new Square();
        int[] result = arraySqare.calculate(4);
        int[] expected = {0,1,4,9};
        assertThat(result, is(expected));

    }

}