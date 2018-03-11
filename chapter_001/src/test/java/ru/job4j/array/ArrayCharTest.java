package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayCharTest {

    @Test
    public void whenStartWithPrefixThanTrue(){
        ArrayChar myString = new ArrayChar("Hellouuuuu");
        boolean result = myString.startWith("Hell");
        assertThat(result, is(true));

    }

    @Test
    public void whenStartWithoutPrefixThanFalse(){
        ArrayChar myString = new ArrayChar("Hellouuuuu");
        boolean result = myString.startWith("Helo");
        assertThat(result, is(false));
    }

}