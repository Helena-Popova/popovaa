package ru.job4j.coffeemachine;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.coffeemachine.exceptions.ValueError;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoffeeMachineTest {

    CoffeeMachine coffeeMachine = new CoffeeMachine();
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void changesTake() {
        int[] result = coffeeMachine.changes(47, 35);
        assertThat(result, is(new int[] {10, 2}));
    }

    @Test
    public void changesTakeNull() {
        int[] result = coffeeMachine.changes(35, 35);
        assertThat(result, is(new int[] {}));
    }

    @Test
    public void changesTakeOneCoin() {
        int[] result = coffeeMachine.changes(36, 35);
        assertThat(result, is(new int[] {1}));
    }

    @Test
    public void valueIsNegative() throws ValueError {
        exception.expect(ValueError.class);
        exception.expectMessage("Недостаточно денег для выдачи кофе");
        coffeeMachine.changes(5, 35);

    }

    @Test
    public void priceIsNegative() throws ValueError {
        exception.expect(ValueError.class);
        exception.expectMessage("Неверно указана цена товара");
        coffeeMachine.changes(5, -4);
    }

}