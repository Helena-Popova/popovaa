package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class TurnTest {

    @Test
    public void whenTurnArrayWithAnEvenlength() {
        int[] myEvenArray = {1, 2, 3, 4};
        Turn someAlgoritmTurn = new Turn();
        int[] result = someAlgoritmTurn.back(myEvenArray);
        assertThat(result, is(new int[]{4, 3, 2, 1}));
    }

    @Test
    public void whenTurnArrayWithAnOddlength() {
        int[] myOddArray = {1, 2, 3, 4, 5};
        Turn someAlgoritmTurn = new Turn();
        int[] result = someAlgoritmTurn.back(myOddArray);
        assertThat(result, is(new int[]{5, 4, 3, 2, 1}));
    }
}