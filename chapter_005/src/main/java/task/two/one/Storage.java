package task.two.one;

import lombok.Getter;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

@ThreadSafe
public class Storage implements UserStorage {
    @Getter
    @GuardedBy("users")
    HashMap<Integer, User> users = new HashMap<>();

    @Override
    public boolean add(User user) {
        boolean result  = false;
        synchronized (users) {
            if (!users.containsKey(user.getId())) {
                users.put(user.getId(), user);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean update(User user) {
        boolean result  = false;
        synchronized (users) {
            if (users.containsKey(user.getId())) {
                users.put(user.getId(), user);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(User user) {
        boolean result  = false;
        synchronized (users) {
            if (users.containsKey(user.getId()) && users.get(user.getId()).equals(user)) {
                users.remove(user.getId(), user);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        synchronized (users) {
            if (users.containsKey(fromId) && users.containsKey(toId)) {
                result = users.get(fromId).changeAmound(-amount);
                if (result) {
                    users.get(toId).changeAmound(amount);
                }
            }
        }
        return result;
    }
}
