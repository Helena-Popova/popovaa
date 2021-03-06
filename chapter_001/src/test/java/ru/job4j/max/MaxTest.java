package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max coupleNumbers = new Max();
        assertThat(coupleNumbers.max(1, 2), is(2));
    }

    @Test
    public void whenThirdMoreThanAll() {
        Max coupleNumbers = new Max();
        assertThat(coupleNumbers.max(1, 2, 3), is(3));
    }

}