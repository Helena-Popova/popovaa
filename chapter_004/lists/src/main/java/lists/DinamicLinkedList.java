package lists;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    int modCount = 0;
    int size = 0;

    public static class Node<E> {
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
        } else {
            this.first.previous = newLink;
            newLink.next = first;
            this.first = newLink;
        }
        size++;
    }

    public E get(int index) {
        checkIndex(index);

        Node<E> result = this.first;
        int i = size - 1;
        while (i != index) {
            result = result.next;
            i--;
        }
        return result.date;
    }

    public E remove(int index) {
        checkIndex(index);

        int step = size - 1;
        Node<E> result = this.first;
        while (step != index) {
            result = result.next;
            step--;
        }
        replaseReference(result);
        size--;
        return result.date;
    }

    public int getSize() {
        return size;
    }

    /**
     * замена ссылок при удалении элемента
     * @param ref
     */
    private void replaseReference(Node<E> ref) {
        if (ref.next != null) {
            ref.next.previous = ref.previous;
        }
        if (ref.previous != null) {
            ref.previous.next = ref.next;
        } else {
            first = ref.next;
        }
    }

    private void checkIndex(int srcIndex) {
        if (srcIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (srcIndex < 0) {
            throw new NoSuchElementException();
        }
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
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                replaseReference(previousStep);
                modCount++;
                expectedModCount++;
                size--;
            }

        };
        return iterator;
    }

}