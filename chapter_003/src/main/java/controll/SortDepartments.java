package controll;

import sort.User;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Реализовать возможность сортировки массива кодов подразделений по возрастанию и убыванию,
 * при которых сохранялась бы иерархическая структура (показано далее в примерах сортировки),
 * т.к. отсортированный массив используется для отображения категорий пользователю.
 */

public class SortDepartments {
    /**
     * Сортировка первым способом:
     */

    /**
     * из входящего списка параметров формируется list наших обьектов(Departments)
     * Проверяется наличие в списке названий главных департаментов ( еси их нет,то добавляются)
     *
     * @param input
     * @return
     */

    public List<Departments> getList(String[] input) {
        Stream<Departments> stream = Arrays.stream(input).map(Departments::new);
        List<Departments> departments = stream.collect(Collectors.toList());
        List<Departments> addFor = new ArrayList<>();
        departments.forEach(x -> {
            Departments temp = new Departments(x.getMainD());
            if (!departments.contains(temp) && !addFor.contains(temp)) {
                addFor.add(temp);
            }
        });
        departments.addAll(addFor);
        return departments;
    }

    /**
     * Сортировка я обратном порядке порядке
     *
     * @param input
     * @return
     */
    public String[] getSortDecrease(String[] input) {
        Departments[] result = getList(input).stream().collect(Collectors.toList()).toArray(new Departments[getList(input).size()]);
        Arrays.sort(result, (o1, o2) -> {
            int out = -o1.getMainD().compareTo(o2.getMainD());
            if (out == 0) {
                int limit = Math.min(o1.getServiceInfo().length, o2.getServiceInfo().length);
                for (int i = 0; i < limit; i++) {
                    out = o1.getServiceInfo()[i].compareTo(o2.getServiceInfo()[i]);
                    if (out != 0) {
                        break;
                    }
                }
                if (out == 0 && o1.getServiceInfo().length != o2.getServiceInfo().length) {
                    out = o1.getServiceInfo().length - o2.getServiceInfo().length;
                }
            }
            return out;
        });
        return Arrays.stream(result).map(i -> i.toString()).collect(Collectors.toList()).toArray(new String[result.length]);
    }

    /**
     * Сортировка в прямом порядке
     *
     * @param input
     * @return
     */
    public String[] getSortIncrease(String[] input) {
        String[] result = getList(input).stream().map(i -> i.toString()).collect(Collectors.toList()).toArray(new String[getList(input).size()]);
        Arrays.sort(result);
        return result;
    }

    /**
     * Второй метод: сортировка с помощью уже отсортированного множеества.
     */

    /**
     * Берет входящий список параметроа. Образует из него упорядоченную структуру.
     * Добавляет название недостающи департаментов
     *
     * @param input
     * @return
     */
    public String[] getSort(String[] input) {
        Set<String> result = new TreeSet<>(Arrays.asList(input));
        Set<String> temp = new TreeSet<>();
        Iterator<String> it = result.iterator();
        while (it.hasNext()) {
            Departments first = new Departments(it.next());
            if (!result.contains(first.getMainD())) {
                temp.add(first.getMainD());
            }
        }
        result.addAll(temp);
        return result.toArray(new String[result.size()]);
    }

    /**
     * СОртирует в обратном порядке уже имеющееся отсортированное дерево
     *
     * @param input
     * @return
     */
    public String[] getSortReverse(String[] input) {
        List<String> result = Arrays.asList(getSort(input));
        result.sort((String o1, String o2) -> {
            Departments first = new Departments(o1);
            Departments second = new Departments(o2);
            return -first.getMainD().compareTo(second.getMainD());
        });
        return result.toArray(new String[result.size()]);
    }

}
