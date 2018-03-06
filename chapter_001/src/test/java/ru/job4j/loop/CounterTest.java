package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CounterTest {
    @Test
    public void isItRightSumm() {
        Counter mySumm = new Counter();
        assertThat(mySumm.add(1,10), is(30));
    }
}