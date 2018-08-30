import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MagnitTest {

    private Magnit program = new Magnit();

    @Test
    public void ifAdd1000000ThenResultIs1784293664() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        try {
            program.init(1000000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int expect = 0;
        for (int i = 1; i <= 1000000; i++) {
            expect = expect + i;
        }
        assertThat(os.toString(), is(String.valueOf(expect)));
    }

    /**
     * Test №2.
     */
    @Test
    public void ifAdd10ThenResultIs55() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        try {
            program.init(10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int expect = 0;
        for (int i = 1; i <= 10; i++) {
            expect = expect + i;
        }
        assertThat(os.toString(), is(String.valueOf(expect)));
    }


}