package containers;
import java.util.NoSuchElementException;

import lists.DinamicLinkedList;

import java.util.Iterator;

public class SimpleStack<T> {
    DinamicLinkedList<T> linkedList = new DinamicLinkedList<>();


    public T poll() {
        T result = linkedList.get(linkedList.getSize() - 1);
        linkedList.remove(linkedList.getSize() - 1);
        return result;
    }

    public void push(T value) {
        linkedList.add(value);
    }
}