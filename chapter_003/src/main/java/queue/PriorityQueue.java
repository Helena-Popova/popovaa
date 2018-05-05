package queue;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        ListIterator<Task> iter = tasks.listIterator();
        int index = 0;
        while (iter.hasNext() && iter.next().getPriority() < task.getPriority()) {
            index = iter.nextIndex();
        }
        tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }

    public LinkedList<Task> getTasks() {
        return tasks;
    }
}
