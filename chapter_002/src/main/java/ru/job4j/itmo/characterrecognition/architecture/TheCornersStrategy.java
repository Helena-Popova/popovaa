package ru.job4j.itmo.characterrecognition.architecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Распознавание числа по методу минимального угла до ближайшего соседа.
 * Минутка занимательной математики:
 * Углом между двумя векторами, отложенными от одной точки,
 * называется кратчайший угол, на который нужно повернуть
 * один из векторов вокруг своего начала до положения сонаправленности с другим вектором.
 * Косинус угла между векторами равен скалярному произведению векторов,
 * поделенному на произведение модулей векторов.
 *
 * То есть просто ищем косинусы между распознаваемой картинкой (ее вектором) и каждым из веткоров
 * в нашей мапе, закруженной из основного файла. вектор, с которым был составлен наименьший угол,
 * будет считаться числом, которым мы распознали.
 */
public class TheCornersStrategy {

    private List<DataJPG> images = new ArrayList<>();

    public TheCornersStrategy(List<DataJPG> images) {
        this.images = images;
    }

    /**
     * Находит вектор с которым newJPG имеет наименьший угол
     * @param newJPG
     * @return
     */
    public int getMinNeighborbyCos(DataJPG newJPG) {
        DataJPG minJPG = this.images.get(0);
        for (int index = 1; index < this.images.size(); index++) {
            if (this.images.get(index).getCos(newJPG) < minJPG.getCos(newJPG)) {
                minJPG = this.images.get(index);
            }
        }
        return minJPG.getLable();
    }

}
