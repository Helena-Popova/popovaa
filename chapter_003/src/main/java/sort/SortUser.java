package sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 Необходимо создать модель User с полями name, age.
 Класс User должен реализовать интерфейс Comparable.
 В классе SortUser написать метод public Set<User> sort (List<User>),
 который будет возвращать TreeSet пользователей,
 отсортированных по возрасту в порядке возрастания.
 */
public class SortUser {

    public Set<User> sort(List<User> userList) {
        Set<User> result = new TreeSet<>();
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        });
        result.addAll(userList);
        return result;
    }
}
