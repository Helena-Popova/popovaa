package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Helena
 * @version 1.0
 * @since 14.03.18
 */

public class PartWordTest {

    @Test
    public void whenSubIsInTheWorldThenTrue() {
        String origin = "Привет";
        String sub = "иве";
        PartWord blaBla = new PartWord();
        boolean result = blaBla.contains(origin, sub);
        assertThat(result, is(true));
    }

    @Test
    public void whenSubIsNotInTheWorldThenFalse() {
        String origin = "Привет";
        String sub = "Пока";
        PartWord blaBla = new PartWord();
        boolean result = blaBla.contains(origin, sub);
        assertThat(result, is(false));
    }

    @Test
    public void whenSubIsInTheWordWithComparePartThanTrue() {
        String origin = "LaLaLend";
        String sub = "LaL";
        PartWord blaBla = new PartWord();
        boolean result = blaBla.contains(origin, sub);
        assertThat(result, is(true));
    }

}