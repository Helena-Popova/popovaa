package task.two.one;

/**
 *1. Создать класс - структуру данных для хранение пользователей UserStorage.
 2. В заголовке класса обозначить аннотацию @ThreadSafe из библиотеки

 3. Хранилище должно иметь методы boolean add (User user), boolean update(User user), boolean delete(User user).

 4. И особый метод transfer(int fromId, int toId, int amount);

 5. Структура данных должна быть потокобезопасная;

 6. В структуре User Должны быть поля int id, int amount.

 amount - это сумма денег на счете пользователя.
 * @author Helena
 */

public interface UserStorage {

    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    boolean transfer(int fromId, int toId, int amount);

}
