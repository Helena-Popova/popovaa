import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    int modCount = 0;
    int size = 0;

    private static class Node<E> {
        E date = null;
        Node<E> next = null;
        Node<E> previous = null;

        Node(E date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "date=" + date.toString()
                    + '}';
        }
    }

    public void add(E value) {
        Node<E> newLink = new Node<E>(value);
        if (this.first == null) {
            this.first = newLink;
            this.first.next = null;
        } else {
            this.first.previous = newLink;
            newLink.next = first;
            this.first = newLink;
        }
        size++;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = this.first;
        int i = 0;
        while (i < index) {
            result = result.next;
            i++;
        }
        return result.date;
    }

    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            private Node<E> iteratorStep = first;
            private Node<E> previousStep = null;
            int expectedModCount = modCount;

            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iteratorStep != null;
            }

            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                previousStep = iteratorStep;
                iteratorStep = iteratorStep.next;
                return previousStep.date;
            }

            public void remove() {
                if (previousStep.previous != null) {
                    previousStep.previous.next = previousStep.next;
                } else {
                    previousStep.next.previous = null;
                    first = previousStep.next;
                }
                if (previousStep.next != null) {
                    previousStep.next.previous = previousStep.previous;
                } else {
                    previousStep.previous.next = null;
                }
                modCount++;
                expectedModCount++;
                size--;
            }

        };
        return iterator;
    }


    public boolean hasCycle() {
        boolean result = false;
        Iterator<E> iterator = iterator();
        Iterator<E> iterator1 = iterator();
        while (iterator.hasNext()) {
            E step = iterator.next();
            while (iterator1.hasNext()) {
                if (iterator.next() == iterator1.next()) {
                    System.out.println("log");
                    result = true;
                }
            }
        }
        return result;
    }
}