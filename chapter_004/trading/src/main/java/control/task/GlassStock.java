package control.task;

import control.task.base.classes.DoublePair;
import control.task.base.classes.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * биржевой стакан
 * @author Helena
 */
@EqualsAndHashCode
public class GlassStock implements Comparable<GlassStock> {
    @EqualsAndHashCode.Exclude
    private Map<Integer, List<DoublePair>> requests = new TreeMap<>();

    @Getter
    @Setter
    private String issuer;

    /**
     * Инициализируется эммитентом ( владельцем) Он берется из getBook заявки
     * @param issuer
     */
    public GlassStock(String issuer) {
        this.issuer = issuer;
    }

    /**
     * Добавление заявки в стакан
     * 1. - происходит операция рекомбинации сначала ,
     * если тип TypeRequest.ADD(смотрим что в стакане можно сразу обналичить),
     * если Delete,то сразу переходим к удалению.
     * 2. - если заявка срекомбинировала с каким-то другими заявками в стакане,то ее volum уменьшается на колличество
     * срекомбенировавших и добавляется уже elementAdd с новым параметром volum.( это удобно, потому что не нужно сначала добавлять,
     * а потом уже смотреть,какие можно срекомбинировать)
     * @param sRequest
     * @return
     */
    public boolean addRequest(RequestStock sRequest) {
        boolean result = false;
        RequestStock elementAdd = sRequest.getType().equals(TypeRequest.ADD) ? recombinationAct(sRequest) : sRequest;
        if (requests.containsKey(elementAdd.getPrice())) {
            if (requests.get(elementAdd.getPrice()).contains(new DoublePair(elementAdd))) {
                requests.get(elementAdd.getPrice()).stream()
                        .filter(pair -> pair.getId() == elementAdd.getId())
                        .forEach(element -> element.addInfoNewReq(elementAdd));
            } else if (sRequest.getType().equals(TypeRequest.ADD)) {
                Set<DoublePair> pairs = new HashSet<>(requests.get(elementAdd.getPrice()));
                pairs.add(new DoublePair(elementAdd));
                requests.put(elementAdd.getPrice(), new ArrayList<DoublePair>(pairs));
                result = true;
            }
        } else if (sRequest.getType().equals(TypeRequest.ADD)) {
            requests.put(elementAdd.getPrice(), Arrays.asList(new DoublePair(elementAdd)));
            result = true;
        }
        return result;
    }

    /**
     * проходимся по всех заявкам с ценой ниже или равной sRequest.
     *
     * @param sRequest
     * @return
     */
    public RequestStock recombinationAct(RequestStock sRequest) {
        List<DoublePair> temp;
        int sub = sRequest.getVolume();
        Iterator<Integer> iterator = requests.keySet().iterator();
        LabelOne: while (iterator.hasNext()) {
            int price = iterator.next();
            temp = requests.get(price);
            if (temp != null) {
                for (int i = 0; i < temp.size(); i++) {
                    sub = temp.get(i).recombinatio(sRequest.getAction(), sub);
                    sRequest.addVolume(-sRequest.getVolume() - sub);
                    if (sub == 0 || price > sRequest.getPrice()) {
                        break LabelOne;
                    }
                }
            }
        }
        return sRequest;
    }

    /**
     * Колличество заявок на покупку с данным прайсом
     * @param price
     * @return
     */
    public int getForBuy(int price) {
        return requests.get(price).stream().mapToInt(step -> step.getVolumAsk()).sum();
    }

    /**
     * Колличество заявок на продажу с данным прайсом
     * @param price
     * @return
     */
    public int getForSale(int price) {
        return requests.get(price).stream().mapToInt(step -> step.getVolumBit()).sum();
    }


    /**
     * Для данного стакана формируется строка с последовательным указанием всех заявок, укорядоченных по убыванию цены
     * Формат : кол-во продающихся         цена             кол-во на покупку
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder  = new StringBuilder();
        requests.keySet().stream().sorted(Comparator.reverseOrder())
                .forEach(x-> stringBuilder
                        .append(getForSale(x))
                        .append(" ")
                        .append(x)
                        .append(" ")
                        .append(getForBuy(x))
                        .append("\n"));

        return stringBuilder.toString();
    }

    @Override
    public int compareTo(GlassStock o) {
        return this.getIssuer().compareTo(o.getIssuer());
    }


}
