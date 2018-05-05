package queue;

/**
 * Задача с приоритетом
 *@author Helena
 *@version 1.0
 *@since 06.03.18
 */
public class Task {
    private String desc;
    private int priority;

    /**
     * @param desc описание
     * @param priority приоритет
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{"
                + "desc='"
                + desc
                + '\''
                + ", priority="
                + priority
                + '}';
    }
}
