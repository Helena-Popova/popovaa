import lombok.Data;

import java.util.HashMap;

@Data
public class WordComparer {
    private String first;
    private String second;

    public WordComparer(String one, String two) {
        this.first = one;
        this.second = two;
    }

    public boolean isWordEquals() {
        boolean result = false;
        HashMap<Character, Integer> storage = new HashMap<>();
        this.first.chars().mapToObj(i -> (char) i)
                .forEach(alfa -> {
                    int count = storage.containsKey(alfa) ? storage.get(alfa) + 1 : 1;
                    storage.put(alfa, count);
                });
        result = this.second.chars().mapToObj(i -> (char) i)
                .filter(alfa -> storage.containsKey(alfa)
                        && storage.get(alfa) == second.chars()
                        .mapToObj(a -> (char) a)
                        .filter(betta -> betta.equals(alfa))
                        .count()).count() == this.first.length();
        return result;
    }
}