package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {
    @Test
    public void isItRightFactorial() {
        Factorial factorialOfValue = new Factorial();
        assertThat(factorialOfValue.calc(5), is(120));
    }

    @Test
    public void isItRightFactorialForZerro() {
        Factorial factorialOfValue = new Factorial();
        assertThat(factorialOfValue.calc(0), is(1));
    }

    @Test
    public void isItRightFactoriaForOne() {
        Factorial factorialOfValue = new Factorial();
        assertThat(factorialOfValue.calc(1), is(1));
    }
}