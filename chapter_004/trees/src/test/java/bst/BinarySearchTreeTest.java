package bst;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();


    @Before
    public void setTreeBranch() {
        binarySearchTree.add(1);
        binarySearchTree.add(2);
        binarySearchTree.add(7);
        binarySearchTree.add(3);
    }

    @Test
    public void returnAllElement() {
        Iterator<Integer> iterator = binarySearchTree.iterator();
        assertTrue(iterator.hasNext());
        assertThat(1, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(2, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(7, is(iterator.next()));
        assertTrue(iterator.hasNext());
        assertThat(3, is(iterator.next()));
        assertFalse(iterator.hasNext());
    }

    @Test
    public void seachElements() {
        assertFalse(binarySearchTree.findBy(5).isPresent());
        assertFalse(binarySearchTree.findBy(22).isPresent());
        assertFalse(binarySearchTree.findBy(6).isPresent());
        assertFalse(binarySearchTree.findBy(8).isPresent());
        assertTrue(binarySearchTree.findBy(3).isPresent());
        assertTrue(binarySearchTree.findBy(7).isPresent());
        assertTrue(binarySearchTree.findBy(2).isPresent());
        assertTrue(binarySearchTree.findBy(1).isPresent());
    }
}