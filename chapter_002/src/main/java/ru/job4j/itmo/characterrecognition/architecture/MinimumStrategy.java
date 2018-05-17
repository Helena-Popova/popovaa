package ru.job4j.itmo.characterrecognition.architecture;

import java.util.ArrayList;
import java.util.List;

public class MinimumStrategy {
    private List<DataJPG> images = new ArrayList<>();
    private DataJPG newJPG;

    /**
     * В конструкторе обьявляем список картинок,
     * по которым будет осущетсволяться распознавание нового обьекта
     * @param images наш список картинок выгруженный из файла
     */
    public MinimumStrategy(List<DataJPG> images) {
        this.images = images;
    }

    /**
     * Метод вычисляет "к" ближайших соседей.
     * Соседи вычисляются по нахождению минимума
     * @param count колличество соседей
     * @return возвращает список с ближайшими соседями от нового обьекта
     */
    private List<DataJPG> getMinNeighbors(int count) {
        List<DataJPG> neighbors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            DataJPG minJPG = this.images.get(0);
            for (int index = 1; index < this.images.size(); index++) {
                if (this.images.get(index).getDifference(this.newJPG) < minJPG.getDifference(this.newJPG) && !neighbors.contains(this.images.get(index))) {
                    minJPG = this.images.get(index);
                }
            }
            neighbors.add(minJPG);
        }
        return neighbors;
    }

    /**
     * метод вычисляет класс, который имеет наибольшее колличество входдений
     * в наш список ближайших соседей
     * @return возвращает опредеенный класс  - подразумевается,
     * что новый обьект-картинка так же принадлежит этому классу
     */
    public int mostOftenIncomingClass(DataJPG newData) {
        this.newJPG = newData;
        List<DataJPG> neighbors = getMinNeighbors(1);
        /*int maxJPG = 0;
        int frequency = 0;
        int valueInside = 0;
        for (int i = 0; i < neighbors.size();i++) {
            DataJPG temp = neighbors.get(i);
            for (int index = 0; index < neighbors.size();) {
                if (neighbors.get(index).getLable() == temp.getLable()) {
                    valueInside++;
                    if (valueInside > frequency) {
                        frequency = valueInside;
                        maxJPG = neighbors.get(index).getLable();
                    }
                    neighbors.remove(i);
                } else {
                    index++;
                }
            }
        }*/
        return neighbors.get(0).getLable();
    }



    /**
     * возвращает реальный класс нового обьекта и класс,
     * который был самым часто встречающимся у соседей
     * @return
     */
    @Override
    public String toString() {
        return "Для числа : "
                + newJPG.getLable()
                + ", Распознанный класс = "
                + mostOftenIncomingClass(newJPG);
    }
}
