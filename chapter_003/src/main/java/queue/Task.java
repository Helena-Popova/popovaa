package queue;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return priority == task.priority
                && Objects.equals(desc, task.desc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(desc, priority);
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
