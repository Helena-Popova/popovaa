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
        return new TreeSet<>(userList);
    }

    /**
     * Comparator для метода Collections.sort и отсортировать List<User> по длине имени.
     * Comparator заменила на лямбду
     */
    public List<User> sortNameLength(List<User> userList) {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return userList;
    }

    /**
     * 1 способ
     * Comparator для метода Collections.sort и отсортировать List<User> по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     * @return
     */
    public List<User> sortByAllFields(List<User> userList) {
        userList.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        return userList;
    }

    /**
     * 2 способ
     * Comparator для метода Collections.sort и отсортировать List<User> по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     * @return
     */
    public List<User> sortByAllFieldsBy2Method(List<User> userList) {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
        return userList;
    }
}
