package ru.job4j.strategypattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class Triangle
 * @author HelenaPopova
 * @since 1.0
 */
public class PaintTest {
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadBefore() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void loadAfter() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenDrawSquare() {
        new Paint(new Square()).draw();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(" +++++\n")
                                .append("+     +\n")
                                .append("+     +\n")
                                .append(" +++++\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint(new Triangle()).draw();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   +   \n")
                                .append("  +++  \n")
                                .append(" +++++ \n")
                                .append("+++++++\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

}