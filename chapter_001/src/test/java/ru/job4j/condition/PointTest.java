package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenDisstancebetweenPointTwoThenReturnTwo() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 2);
        double result = pointA.distanseTo(pointB);
        assertThat(result, is(2D));
    }

}