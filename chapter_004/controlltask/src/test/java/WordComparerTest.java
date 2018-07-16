import org.junit.Test;

import static org.junit.Assert.*;

public class WordComparerTest {
    WordComparer wordComparer;

    @Test
    public void testWithSameStrings() {
        wordComparer = new WordComparer("malina", "anilam");
        assertTrue(wordComparer.isWordEquals());
    }

    @Test
    public void testWithDiferentStrings() {
        wordComparer = new WordComparer("malina", "calina");
        assertFalse(wordComparer.isWordEquals());
    }
}