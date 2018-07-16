import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchAppearancesTest {
    SearchAppearances searchAppearances = new SearchAppearances();
    String filename = "notes3.txt";
    String text = "Hwo is Jon Gold ? Jon is mysterious engineer";

    @Before
    public void writeToFileTestText() {
        try (FileWriter writer = new FileWriter(filename)) {
            // запись всей строки
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void countNumbersWord() {
        searchAppearances.loadFile(filename);
        assertTrue(searchAppearances.getIndexes4Word("Hwo").contains(text.indexOf("Hwo")));
        assertTrue(searchAppearances.getIndexes4Word("is").contains(text.indexOf("is")));
        assertTrue(searchAppearances.getIndexes4Word("jon").contains(text.indexOf("Jon")));
        assertTrue(searchAppearances.getIndexes4Word("jon").contains(text.indexOf("Jon", 10)));
        assertTrue(searchAppearances.getIndexes4Word("gOld").contains(text.indexOf("Gold")));
        assertThat(null, is(searchAppearances.getIndexes4Word("gOl")));
    }
}