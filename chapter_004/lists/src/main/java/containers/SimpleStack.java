package containers;
import java.util.NoSuchElementException;

import lists.DinamicLinkedList;

import java.util.Iterator;

public class SimpleStack<T> {
    DinamicLinkedList<T> linkedList = new DinamicLinkedList<>();


    public T poll() {
        Iterator<T> iterator = linkedList.iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        T result = iterator.next();
        iterator.remove();
        return result;
    }

    public void push(T value) {
        linkedList.add(value);
    }
}