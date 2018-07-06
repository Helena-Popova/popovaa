package control.task;

import control.task.base.classes.ActionRequest;
import control.task.base.classes.TypeRequest;

import java.util.Objects;

public class RequestStock implements Comparable<RequestStock> {

    private int id;

    private String book;

    private TypeRequest type;

    private ActionRequest action;

    private int price;

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


    public int getId() {
        return this.id;
    }


    public void setId(int sId) {
        this.id = sId;
    }

    public String getBook() {
        return this.book;
    }

    public void setBook(String sBook) {
        this.book = sBook;
    }

    public TypeRequest getType() {
        return this.type;
    }


    public void setType(TypeRequest sType) {
        this.type = sType;
    }


    public ActionRequest getAction() {
        return this.action;
    }


    public void setAction(ActionRequest sAction) {
        this.action = sAction;
    }


    public int getPrice() {
        return this.price;
    }


    public void setPrice(int sPrice) {
        this.price = sPrice;
    }


    public int getVolume() {
        return this.volume;
    }


    public void setVolume(int sVolume) {
        this.volume = sVolume;
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

    /**
     * заявки одинаковые,только если они одинаковы по цене,
     * владельцу
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestStock that = (RequestStock) o;
        return price == that.price
                && Objects.equals(book, that.book)
                && action == that.action;
    }

    @Override
    public int hashCode() {

        return Objects.hash(book, action, price);
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
