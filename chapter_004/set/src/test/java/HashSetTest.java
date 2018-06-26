import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class HashSetTest {
    HashSet<String> strings = new HashSet<>();

    @Before
    public void add() {
        strings.add("First");
        strings.add("Second");
        strings.add("Third");
        strings.add("Fourth");
        strings.add("Fifth");
    }

    @Test
    public void contains() {
        assertTrue(strings.contains("First"));
        assertTrue(strings.contains("Third"));
        assertTrue(strings.contains("Fifth"));
        assertFalse(strings.contains("Sixth"));
    }

    @Test
    public void remove() {
        assertTrue(strings.remove("First"));
        assertFalse(strings.contains("First"));
        assertTrue(strings.remove("Third"));
        assertFalse(strings.contains("Third"));
        assertFalse(strings.remove("Sixth"));
    }

    @Test
    public void iterator() {
        Iterator iterator = strings.iterator();
        assertTrue(iterator.hasNext());
        System.out.println(iterator.next());
        assertTrue(iterator.hasNext());
        System.out.println(iterator.next());
        assertTrue(iterator.hasNext());
        System.out.println(iterator.next());
        assertTrue(iterator.hasNext());
        System.out.println(iterator.next());
        assertTrue(iterator.hasNext());
        System.out.println(iterator.next());
        assertFalse(iterator.hasNext());
    }
}