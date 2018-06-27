import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapUsers {

    public Map<User, Object> addUsers(User ... users) {
        Map<User, Object> map = new HashMap<>();
        Arrays.stream(users).forEach(user -> map.put(user, new Object()));
        return map;
    }
}
