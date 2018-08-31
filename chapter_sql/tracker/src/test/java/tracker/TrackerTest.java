package tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest extends Item {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        delete(tracker);
        Item item = new Item(1, "test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplacedItemThenTrackerHasChangedItem() {
        Tracker tracker = new Tracker();
        delete(tracker);
        Item first = new Item(2, "test1", "testDescription", 123L);
        Item second = new Item(3, "test2", "testDescription", 124L);
        tracker.add(first);
        tracker.replace(tracker.findAll().get(0).getId(), second);
        assertThat(tracker.findAll().get(0), is(second));
    }

    @Test
    public void whenDeletedItemThenTrackerLostOneItem() {
        Tracker tracker = new Tracker();
        delete(tracker);
        Item first = new Item(4, "test1", "testDescription", 123L);
        Item second = new Item(5, "test2", "testDescription", 124L);
        Item third = new Item(6, "test3", "testDescription", 125L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.delete(tracker.findAll().get(1).getId());
        assertThat(tracker.findAll().get(1), is(third));
    }


    @Test
    public void whenfindByNameItemThenTrackerReturnItemHasThisName() {
        Tracker tracker = new Tracker();
        delete(tracker);
        Item first = new Item("test1", "testDescription", 123L);
        final Item second = new Item();
        Item third = new Item("test3", "testDescription", 125L);
        Item fourth = new Item("test1", "testDescription2", 126L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        ArrayList<Item> result = tracker.findByName("test1");
        assertThat(result.get(1), is(fourth));
    }

    @Test
    public void whenfindByIdItemThenTrackerReturnItemHasThisName() {
        Tracker tracker = new Tracker();
        delete(tracker);
        Item first = new Item("test1", "testDescription", 123L);
        final Item second = new Item();
        Item third = new Item("test3", "testDescription", 125L);
        Item fourth = new Item("test1", "testDescription2", 126L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        int id = tracker.findAll().get(3).getId();
        Item result = tracker.findById(id);
        assertThat(result, is(fourth));
    }

    private void delete(Tracker tracker) {
        ArrayList<Item> items = tracker.findAll();
        Iterator<Item> itemIterator = items.iterator();
        while (itemIterator.hasNext()) {
            tracker.delete(itemIterator.next().getId());
        }
    }

}