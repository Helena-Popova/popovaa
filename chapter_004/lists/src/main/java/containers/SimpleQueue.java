package containers;

import lists.DinamicLinkedList;

import java.util.Iterator;

public class SimpleQueue<T> {

    DinamicLinkedList<T> linkedList = new DinamicLinkedList<>();

    public T poll() {
        Iterator<T> iterator = linkedList.iterator();
        T result = null;
        while (iterator.hasNext()) {
            result = iterator.next();
        }
        iterator.remove();
        return result;
    }

    public void push(T value) {
        linkedList.add(value);
    }

    public boolean isCircle() {
        return linkedList.hasCycle();
    }

}