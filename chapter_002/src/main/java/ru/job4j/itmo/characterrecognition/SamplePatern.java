package ru.job4j.itmo.characterrecognition;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SamplePatern {
    private List<DataJPG> images;

    public SamplePatern(List<DataJPG> images) {
        this.images = images;
    }

    public Comparator<DataJPG> setComparatorByLenght() {
        Comparator<DataJPG> comparatorByLenght = new Comparator<DataJPG>() {
            public int compare(DataJPG o1, DataJPG o2) {
                return Double.compare(o1.getLenght(), o2.getLenght()); }
        };
        return comparatorByLenght;
    }

    public  Comparator<DataJPG> setComparatorByDifference(DataJPG newJPG) {
        Comparator<DataJPG> difference = new Comparator<DataJPG>() {
            public int compare(DataJPG o1, DataJPG o2) {
                return Double.compare(o1.getDifference(newJPG), o2.getDifference(newJPG)); }
        };
        return difference;
    }

    public void findNearestNeighbors(Comparator<DataJPG> comparator) {
        Collections.sort(this.images, comparator);
    }
}
