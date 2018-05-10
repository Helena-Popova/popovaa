package transformations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserConvertTest {
    UserConvert userConvert = new UserConvert();

    @Test
    public void whenAddSomeUsersGetMap() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Manya", "Kiev"));
        users.add(new User(2, "Vanya", "London"));
        assertThat(new User(1, "Manya", "Kiev"), is(userConvert.process(users).values().iterator().next()));
    }

    /**
     * Тест для метода HashMap<Integer, User> processNextByForeach(List<User> list)
     */
    @Test
    public void whenAddSomeUsersGetMapByForeachMethod() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Manya", "Kiev"));
        users.add(new User(2, "Vanya", "London"));
        assertThat(new User(1, "Manya", "Kiev"), is(userConvert.processNextByForeach(users).values().iterator().next()));
    }
}