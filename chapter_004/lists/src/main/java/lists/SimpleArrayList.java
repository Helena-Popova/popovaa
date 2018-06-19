package lists;

import java.util.NoSuchElementException;

public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

    public void add(E date) {
        Node<E> newLink = new Node<E>(date);
        newLink.next = first;
        this.first = newLink;
        size++;
    }

    public E delete() {
        E result = null;
        if (first.next != null) {
            first = first.next;
            result = first.date;
        } else {
            first = null;
        }
        size--;
        return result;
    }

    public E get(int index) {
        if (this.first == null) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        int i = 0;
        while (i < index) {
            result = result.next;
            i++;
        }
        return result.date;
    }

    public int getSize() {
        return size;
    }
}
