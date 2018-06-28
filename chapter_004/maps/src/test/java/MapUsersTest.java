import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapUsersTest {

    MapUsers mapUsers = new MapUsers();
    @Test
    public void check() {
        Calendar calendar = new GregorianCalendar(1975,
                Calendar.DECEMBER, 31);
        System.out.println(new JSONObject(mapUsers.addUsers(
                new User("Alex", 3, calendar),
                new User("Alex", 3, calendar),
                new User("Jon", 5, calendar)))
                .toString());
    }
}