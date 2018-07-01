package simple.tree;

import java.util.Iterator;
import java.util.List;

/**
 * Добавить метод boolean isBinary().
 * Метод должен проверять количество дочерних элементов в дереве. Если их <= 2 - то дерево бинарное.
 * @author Helena
 * @param <E>
 */
public class OakTree<E extends Comparable<E>> extends Tree<E> implements SimpleTree<E> {

    public boolean isBinary() {
        boolean rsl = true;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            List<Node<E>> children =  findBy(iterator.next()).get().leaves();
            if (children.size() > 2) {
                rsl = false;
                break;
            }
         }
        return rsl;
    }
}
