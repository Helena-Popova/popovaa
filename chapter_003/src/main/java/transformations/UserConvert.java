package transformations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Класс преобразования List в Map
 * @author Helena
 */
public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> users = new HashMap<>();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User men = iterator.next();
            users.put(men.getId(), men);
        }
        return users;
    }

    public HashMap<Integer, User> processNextByForeach(List<User> list) {
        HashMap<Integer, User> users = new HashMap<>();
        for (User user : list) {
            users.put(user.getId(), user);
        }
        return users;
    }
}
