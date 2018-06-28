import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *  2. Рассказать, как вычисляется hash функция в HashMap. Привести два варианта: через % и >>
 */
public class HashCodeForMap {
    /**
     * в HashMap хранится хэш талица обьектов класса Entry
     static class Entry implements Map.Entry
     {
     final K key;
     V value;
     Entry next;
     final int hash;

     peblic Entry (int hash, K key, V value, Entry next) {
     ...
     }
     ...//остальной код тут…
     }

     мы видим,что у него кроме полей ключ - значение , есть так же int hash,
     и  Entry next - оно на случай если возникнет коллизия и в ячейке будет связанный список.

     Когда мы добавляем обьект в мапу,то создается обьект Entry реализующий интерфейс Map.Entry и его hash равен хеш коду ключа обьекта

    индекс ячейки, куда мы поместим новый обьек, ищется по вычесленному остатку от деления hash на размер хэш таблицы */

    /**
     * если мы решим положить ключ - значение   в мапу, то  хеш функция для нового Entry создаться так
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // по данным значениям создаться  new Entry(hash, key, value, null);
}
