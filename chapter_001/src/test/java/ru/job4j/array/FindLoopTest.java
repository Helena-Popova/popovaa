package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindLoopTest {

    @Test
    public void whenFindRightIndexFrom10Numbers() {

        int[] myMassif = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        FindLoop someFindAlgotitm = new FindLoop();
        int result = someFindAlgotitm.indexOf(myMassif, 3);
        assertThat(result, is(2));
    }

    @Test
    public void whenFindNonexistentElement() {
        int[] myMassif = {33, 23, 24, 45, 56, 46};
        FindLoop someFindAlgotitm = new FindLoop();
        int result = someFindAlgotitm.indexOf(myMassif, 32);
        assertThat(result, is(-1));
    }

    @Test
    public void whenFindNullButIndexWrong() {
        int[] myMassif = {3, 23, 24, 45, 56, 46};
        FindLoop someFindAlgotitm = new FindLoop();
        int result = someFindAlgotitm.indexOf(myMassif, 0);
        assertThat(result, is(0));
    }

}