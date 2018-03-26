package ru.job4j.strategypattern;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест-класс для вывода треугольника.
 * @author HelenaPopova
 * @since 23/03/18
 */
public class TriangleTest {
    @Test
    public void drawTrinagle() {
        Triangle shape = new Triangle();
        assertThat(shape.draw(), is(new StringBuilder()
                .append("   +   \n")
                .append("  +++  \n")
                .append(" +++++ \n")
                .append("+++++++\n")
                .toString()));
    }

}