import lombok.Data;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;
import java.nio.CharBuffer;

@Data
public class SearchAppearances {

    TreeMap<String, Set<Integer>> appearanes = new TreeMap<>();

    /**
     * Загрузка данных из файла и построение индекса.
     *
     * @param filename
     */
    public void loadFile(String filename) {
        List<Character> world = new ArrayList<>();
        try (FileReader reader = new FileReader(filename)) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }

            }
            reader.close();
            toMap(buf);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void toMap(char[] buf) {
        /**
         * место слова в файле
         */
        List<Integer> count = Arrays.asList(0);

        /**
         * билдер для слова
         */
        StringBuilder stringBuilder = new StringBuilder();

        /**
         * проходимся по буферу, состаляем слово, как только доходим до пробела,
         * то записываем слово в мапу
         */
        CharBuffer.wrap(buf).chars().forEach(alfa -> {
            if (alfa == ' ' && stringBuilder.length() != 0 || count.get(0) == buf.length - 1) {
                String word = stringBuilder.toString().toLowerCase();
                if (!appearanes.containsKey(word)) {
                    appearanes.put(word, new HashSet<>());
                }
                appearanes.get(word).add(count.get(0) - word.length());
                stringBuilder.setLength(0);
            } else {
                stringBuilder.append((char) alfa);

            }
            count.set(0, count.get(0) + 1);
        });
    }

    /**
     * Возвращает список позиций слова в файле. Если данного слова в файле нет, то возвращается null.
     *
     * @param searchWord
     * @return
     */
    public Set<Integer> getIndexes4Word(String searchWord) {
        Set<Integer> result = new TreeSet<>();
        appearanes.entrySet().stream().filter(enty -> enty.getKey().contains(searchWord.toLowerCase())
        ).forEach(state -> result.addAll(state.getValue()));
        return !result.isEmpty() ? result : null;
    }
}
