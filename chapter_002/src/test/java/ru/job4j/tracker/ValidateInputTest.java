package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        input.ask("Enter", temp);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }

    @Test
    public void whenInvalidRange() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"-1", "1"}));
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(Arrays.stream(new int[] {0, 1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        input.ask("Enter: ", temp);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, select key from range.%n")
                )
        );
    }
}