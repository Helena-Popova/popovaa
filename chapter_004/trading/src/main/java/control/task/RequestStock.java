package control.task;

import control.task.base.classes.ActionRequest;
import control.task.base.classes.TypeRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@EqualsAndHashCode
public class RequestStock implements Comparable<RequestStock> {

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private int id;

    @Getter
    @Setter
    private String book;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private TypeRequest type;

    @Getter
    @Setter
    private ActionRequest action;

    @Getter
    @Setter
    private int price;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private int volume;

    public RequestStock(int id, String book, TypeRequest type, ActionRequest action, int price, int volume) {
        this.id = id;
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    /**
     * это специальный констуртор для удобства , инициализирует заявку с обратным типом getAction и нулевым колличеством
     * @param requestStock
     */
    public RequestStock(RequestStock requestStock) {
        this.id = requestStock.getId();
        this.book = requestStock.getBook();
        this.type = requestStock.getType();
        this.action = requestStock.getAction().equals(ActionRequest.BID) ? ActionRequest.ASK : ActionRequest.BID;
        this.price = requestStock.getPrice();
        this.volume = 0;
    }



    /**
     * для коллектировки колличества
     * @param sVolume
     * @return false если не можем убрать больше заявок ,чем есть !
     */
    public boolean addVolume(int sVolume) {
        if (this.volume + sVolume < 0) {
            return false;
        }
        this.volume += sVolume;
        return true;
    }


    @Override
    public int compareTo(RequestStock o) {
        int result = this.book.compareTo(o.getBook());
        if (result == 0) {
            result = this.price - o.getPrice();
        }
        return -result;
    }

    @Override
    public String toString() {
        return "RequestStock{"
                + "id =" + id
                + ", book = '" + book + '\''
                + ", type = " + type
                + ", action = " + action
                + ", price = " + price
                + ", volume = " + volume
                + '}';
    }
}
