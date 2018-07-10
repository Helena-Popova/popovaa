package control.task.base.classes;

import control.task.RequestStock;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * Пара заявок для одного id;
 *  private RequestStock bit - заявки на продажу
 *  private RequestStock ask - заявки на покупку
 */
@EqualsAndHashCode
public class DoublePair {

    @EqualsAndHashCode.Exclude
    private RequestStock bit;

    @EqualsAndHashCode.Exclude
    private RequestStock ask;

    private int id;

    /**
     * Можно инициализировать класс одной входящей заявкой,
     * конструктор сам определит , какого она типа, а в другую запишет new RequestStock в противоположным типом ActionRequest
     * и voltage = 0;
     * @param one ходящая заявка
     */
    public DoublePair(RequestStock one) {
        id = one.getId();
        if (one.getAction().equals(ActionRequest.BID)) {
            bit = one;
            ask = new RequestStock(one);
        } else {
            ask = one;
            bit = new RequestStock(one);
        }
    }
    public DoublePair(RequestStock one, RequestStock two) {
        id = one.getId();
        if (one.getAction().equals(two.getAction())) {
            throw new UnsupportedOperationException();
        }
        if (one.getAction().equals(ActionRequest.BID)) {
            this.bit = one;
            this.ask = two;
        } else {
            this.bit = two;
            this.ask = one;
        }
    }

    public RequestStock getBit() {
        return bit;
    }

    public void setBit(RequestStock bit) {
        this.bit = bit;
    }

    public RequestStock getAsk() {
        return ask;
    }

    public void setAsk(RequestStock ask) {
        this.ask = ask;
    }

    public int getId() {
        return id;
    }

    /**
     * метод отвечает за удаление или добавления заявок bit  и ask для данного id;
     * то есть менятеся их колличество Volume;
     * @param request
     * @return
     */
    public boolean addInfoNewReq(RequestStock request) {
        boolean result = false;
        int subVolutm = request.getType().equals(TypeRequest.ADD) ? request.getVolume() : -request.getVolume();
        if (request.getAction().equals(ActionRequest.BID)) {
            result = bit.addVolume(subVolutm);
        } else {
            result = ask.addVolume(subVolutm);
        }
        return result;
    }

    /**
     * мы должны срекомбинировать колличество заявок для разных типов. Если приходит заявка типа actionRequest,
     * например - BID,
     * то колличество заявок противоположного типа упеньшается - то есь ask;
     * Эта функция не зависит от id, так как мы модем продать или купить у разного типа пользователей.
     * КОгда приходит новая заявка, мы предворительно смотрим ее тип. вызываем эту функцию, которая обзодит все судетсвующие заявки
     *  с противоположным типом и соответсвующей ценой, постепенно от id к id уменьшая их колличестов.
     *  (Если срекомбинировались все заявки у одной id, то переходим к другой)
     * @param actionRequest
     * @param number
     * @return
     */
    public int recombinatio(ActionRequest actionRequest, int number) {
        int sub = 0;
        if (actionRequest.equals(ActionRequest.BID)) {
            sub = number - ask.getVolume();
            ask.addVolume(sub >= 0 ? -ask.getVolume() : -number);
        } else {
            sub = number - bit.getVolume();
            bit.addVolume(sub >= 0 ? -bit.getVolume() : -number);
        }
        return sub > 0 ? sub : 0;
    }

    public int getVolumBit() {
        return bit.getVolume();
    }

    public int getVolumAsk() {
        return ask.getVolume();
    }



    @Override
    public String toString() {
        return "DoublePair{"
                + bit.toString() + " "
                + ask.toString()
                + ", id=" + id + '}';
    }
}
