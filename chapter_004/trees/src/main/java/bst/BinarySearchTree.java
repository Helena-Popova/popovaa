package bst;

import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root = null;

    @Override
    public boolean add(E value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            root.add(new Node<>(value));
        }
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Node<E> data = this.root;
        while (data != null) {
            if (data.getValue().compareTo(value) == 0) {
                rsl = Optional.of(data);
                break;
            } else {
                data = value.compareTo(data.getValue()) > 0 ? data.getRight() : data.getLeft();
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        //горизонтальный (в ширину)
        Iterator<E> iterator = new Iterator<E>() {
            private List<Node<E>> target = new ArrayList<>();
            private int count = 0;
            private int finish = 0;

            {
                target.add(root);
                finish = target.size();
            }

            public boolean hasNext() {
                if (count == finish) {
                    count = 0;
                    target = callMove(target);
                }
                return  count < finish;
            }

            public E next() {
                if (finish == 0) {
                    throw new NullPointerException();
                }
                if (count == finish) {
                    count = 0;
                    target = callMove(target);
                }
                return target.get(count++).getValue();
            }

            private List<Node<E>> callMove(List<Node<E>> list) {
                List<Node<E>> move = new ArrayList<>();
                for (Node<E> step : target) {
                    if (step.getLeft() != null) {
                        move.add(step.getLeft());
                    }
                    if (step.getRight() != null) {
                        move.add(step.getRight());
                    }
                }
                finish = move.size();
                return move;
            }


        };
        return iterator;
    }
}
