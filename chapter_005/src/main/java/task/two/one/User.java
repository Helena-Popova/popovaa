package task.two.one;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class User {
    private int id;
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Нельзя изменить счет так, чтобы он стал отрицательным
     * @param investment
     * @return false , если investment < 0 и this.amount + investment < 0
     */
    public boolean changeAmound(int investment) {
        boolean result = this.amount + investment >= 0;
        if (result) {
            this.amount += investment;
        }
        return result;
    }
}
