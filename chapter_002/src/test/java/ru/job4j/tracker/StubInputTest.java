package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StubInputTest {
    Tracker tracker = new Tracker();
    Item itemF = new Item();
    Item itemS = new Item();
    Item itemT= new Item();

    @Before
    public void loadBefore() {
        itemF = tracker.add(new Item("First", "testDell"));
        itemS = tracker.add(new Item("Second", "testDel2"));
        itemT= tracker.add(new Item("Third", "testDel3"));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "1","6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[3].getName(), is("test name")); // проверяем, что четвертый элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     *
     * Сначал вписыватеся имя заявки, трекер ее ишет, если заявок несколько,
     то пользователь выбирает номер заявки в списке, которую надо заменить,
     если такая заявка одна,то она выбирается автоматически. Опять же!
     Поиск по имени, а не по id. по есть замена это - ввод 2, потом ввод имени заменяемой заявки,
     потом ввод новой информации.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        //Tracker работает немного по другому.
        Input input = new StubInput(new String[]{"1", "2",item.getName(),"test name", "desc", "1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * new String[]{ "3", ...} - метод удалить заявку
     * new String[]{ ..., "2", ...} - удалить заявку с номером 2
     * new String[]{..., "6"}- выйти
     */
    @Test
    public void whenDeleteThenTrackerHasDeleteItem() {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{ "3", "2", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что второй элемент удалился и на его место встал третий.
        assertThat(tracker.getAll()[1].getName(), is("Third"));
    }

    /**
     * new String[]{ "4", ...} - метод найти заявку
     * new String[]{ ..., itemT.getId(), ...} - удалить заявку с таким id
     * new String[]{..., "6"}- выйти
     */
    @Test
    public void whenFindItemByIdThenTrackerReturnItem() {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{ "4", itemT.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нашли третий элемент.
        assertThat(tracker.findById(itemT.getId()).getName(), is("Third"));
    }

}

