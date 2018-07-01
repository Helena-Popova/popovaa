package simple.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {

    Tree<Integer> tree = new Tree<>();


    @Before
    public void setLinks() {
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(1, 11);
        tree.add(1, 12);
        tree.add(2, 21);
        tree.add(2, 22);
    }

    @Test
    public void shouldReturnAllElements() {
        Iterator<Integer> iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        assertThat(0, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(1, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(2, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(11, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(12, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(21, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(22, is(iterator.next()));
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldReturnFalseWhanTryAddSuchElementThatAlreadyExists() {
        assertFalse(tree.add(0, 1));
        assertTrue(tree.add(0, 3));
        assertFalse(tree.add(1, 12));
        assertTrue(tree.add(1, 13));
        assertFalse(tree.add(2, 22));
        assertTrue(tree.add(2, 23));
    }

    @Test
    public void isThisElementExist() {
        assertFalse(tree.findBy(5).isPresent());
        assertTrue(tree.findBy(22).isPresent());
        assertFalse(tree.findBy(6).isPresent());
        assertTrue(tree.findBy(2).isPresent());
    }

}