package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<E extends Comparable<E>> {
    private  Node<E> left = null;
    private  Node<E> right = null;
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        int rsl = child.value.compareTo(this.value);
        if (rsl <= 0) {
            if (left != null) {
                left.add(child);
            } else {
                left = child;
            }
        } else {
            if (right != null) {
                right.add(child);
            } else {
                right = child;
            }
        }
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public E getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }


}
