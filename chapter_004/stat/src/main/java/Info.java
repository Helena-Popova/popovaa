
import lombok.*;


import java.util.ArrayList;
import java.util.List;

public class Info {
    /**
     * Сколько добавлено новых.
     */
    @Getter
    private  Long numberNew;
    /**
     * Сколько изменено. Изменено считается объект в котором изменилось имя. а id осталось одинаковым.
     */
    @Getter
    private  Long numberAdded;
    /**
     * Сколько удалено.
     */
    @Getter
    private Long numberDeleted;

    @Getter
    @Setter
    private List<User> previoues;
    @Getter
    @Setter
    private List<User> current;

    public Info(List<User> srcPrevioues, List<User> srcCurrent) {
        this.previoues = srcPrevioues;
        this.current = srcCurrent;
    }

    public Info getStore() {
        numberNew = current.stream().filter(element -> !previoues.contains(element)).count();
        numberAdded = current.stream().filter(element -> previoues
                .stream().filter(x -> x.equals(element) && !x.getName().equals(element.getName()))
                .count() != 0)
                .count();
        numberDeleted = previoues.stream().filter(element -> !current.contains(element)).count();
        return this;
    }
}
