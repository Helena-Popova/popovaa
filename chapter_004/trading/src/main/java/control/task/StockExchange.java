package control.task;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StockExchange {

    Set<GlassStock> glasses = new TreeSet<>();

    /**
     * биржа добавляет к себе заявку к хранилище стаконов ( стакан выбирается в методе addToGlass)
     * @param request результат успешен или нет.
     * @return  возвращается false если:
     *               запрос отправлен на удаление заявок определенного типа и
     *               мы хотим удалить  большее колличетсво заявок ,чем есть у id .
     */
    public boolean addToGlass(RequestStock request) {
        if (!glasses.contains(new GlassStock(request.getBook()))) {
            glasses.add(new GlassStock(request.getBook()));
        }
        boolean result = glasses.stream().filter(
                glass -> glass.getIssuer().equals(request.getBook()))
                .findFirst().get().addRequest(request);
        return result;
    }

    /**
     * удобный вывод стаканов.
     * названия отсортированны в лексеграфическом порядке,
     * данные в стаканах отсортированны по убыванию цены.
     * Формат : кол-во продающихся         цена             кол-во на покупку
     * @return например:
     * Sber
        5 62 0
        8 12 0

        VTB
        3 13 0
        6 12 0
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        glasses.stream().forEach(glassStock -> {
            stringBuilder.append(glassStock.getIssuer()).append("\n");
            stringBuilder.append(glassStock.toString()).append("\n");
        });
        return stringBuilder.toString();
    }
}
