package simple.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OakTreeTest {

    OakTree<Integer> tree = new OakTree<>();
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
    public void shouldReturnTrueForIsBinaryMethod() {
        assertTrue(tree.isBinary());
    }

    @Test
    public void shouldReturnFelseForIsBinaryMethod() {
        tree.add(22, 221);
        tree.add(22, 222);
        tree.add(22, 223);
        assertFalse(tree.isBinary());
    }
}