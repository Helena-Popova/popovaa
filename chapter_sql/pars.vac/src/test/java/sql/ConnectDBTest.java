package sql;

import helper.Vacancy;
import implement.ParserMain;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConnectDBTest {
    private final Properties properties = ParserMain.loadProperties();
    ConnectDB connectDB = new ConnectDB(properties);

    @Test
    public void connect() throws SQLException, ClassNotFoundException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        assertTrue(connectDB.connect());
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        connectDB.connect();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
        connectDB.insert(Arrays.asList(new Vacancy("coder", calendar.getTime())));
        List<Vacancy> result = connectDB.getAllFirstN(1);
        assertThat(result.get(0).getDescription(), is("coder"));

    }
}