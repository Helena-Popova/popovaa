package ru.job4j.tracker;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest extends Item {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void whenReplacedItemThenTrackerHasChangedItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 124L);
        tracker.add(first);
        tracker.replace(tracker.getAll().get(0).getId(), second);
        assertThat(tracker.getAll().get(0), is(second));
    }

    @Test
    public void whenDeletedItemThenTrackerLostOneItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 124L);
        Item third = new Item("test3", "testDescription", 125L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.delete(tracker.getAll().get(1).getId());
        assertThat(tracker.getAll().get(1), is(third));
    }

    @Test
    public void whenfindAllNullItemThenTrackerReturnWithoutNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        final Item second = new Item();
        Item third = new Item("test3", "testDescription", 125L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        ArrayList<Item> result =  tracker.findAll();
        assertThat(result.get(1), is(third));
    }

    @Test
    public void whenfindByNameItemThenTrackerReturnItemHasThisName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        final Item second = new Item();
        Item third = new Item("test3", "testDescription", 125L);
        Item fourth = new Item("test1", "testDescription2", 126L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        ArrayList<Item> result =  tracker.findByName("test1");
        assertThat(result.get(1), is(fourth));
    }

    @Test
    public void whenfindByIdItemThenTrackerReturnItemHasThisName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        final Item second = new Item();
        Item third = new Item("test3", "testDescription", 125L);
        Item fourth = new Item("test1", "testDescription2", 126L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        String id = tracker.getAll().get(3).getId();
        Item result =  tracker.findById(id);
        assertThat(result, is(fourth));
    }


}