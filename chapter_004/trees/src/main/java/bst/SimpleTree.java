package bst;

import java.util.Optional;

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param value parent.
     * @return
     */
    boolean add(E value);

    Optional<Node<E>> findBy(E value);
}
