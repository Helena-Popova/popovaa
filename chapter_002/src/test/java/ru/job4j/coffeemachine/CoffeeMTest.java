package ru.job4j.coffeemachine;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.coffeemachine.exceptions.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoffeeMTest {

    CoffeeM coffeM = new CoffeeM();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void valueIsNegative() throws ValueError {
        exception.expect(ValueError.class);
        exception.expectMessage("Недостаточно денег для выдачи кофе");
        coffeM.changes(5, 35);

    }

    @Test
    public void priceIsNegative() throws ValueError {
        exception.expect(ValueError.class);
        exception.expectMessage("Неверно указана цена товара");
        coffeM.changes(5, -4);
    }

    @Test
    public void changesTake() {
        int[] result = coffeM.changes(47, 35);
        assertThat(result, is(new int[] {10, 2}));
    }

}