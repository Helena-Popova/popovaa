package ru.job4j.strategypattern;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест-класс для вывода квадрата.
 * @author HelenaPopova
 * @since 23/03/18
 */
public class SquareTest  {
    @Test
    public void drowSquare() {
        Square newShape = new Square();
        assertThat(newShape.draw(), is(new StringBuilder()
                .append(" +++++\n")
                .append("+     +\n")
                .append("+     +\n")
                .append(" +++++\n")
                .toString()));

    }
}