package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Helena
 * @version 1.0
 * @since 09.03.18
 */
public class PaintTest {
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.simplePiramid(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramid5Right() {
        Paint paint = new Paint();
        String rst = paint.pyramid(5);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("    ^    ")
                                .add("   ^^^   ")
                                .add("  ^^^^^  ")
                                .add(" ^^^^^^^ ")
                                .add("^^^^^^^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramid0Right() {
        Paint paint = new Paint();
        String rst = paint.simplePiramid(0);
        System.out.println(rst);
        assertThat(rst, is(""));
    }
}