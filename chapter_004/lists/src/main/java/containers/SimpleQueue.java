package containers;

import lists.DinamicLinkedList;

import java.util.Iterator;

public class SimpleQueue<T> {

    DinamicLinkedList<T> linkedList = new DinamicLinkedList<>();

    public T poll() {
        T result = linkedList.get(0);
        linkedList.remove(0);
        return result;
    }

    public void push(T value) {
        linkedList.add(value);
    }

}