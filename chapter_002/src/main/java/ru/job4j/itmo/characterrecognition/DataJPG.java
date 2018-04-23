package ru.job4j.itmo.characterrecognition;
import java.util.Arrays;
import java.util.Objects;

public class DataJPG {
    private int lable;
    private int[] linearVector;

    public DataJPG(int lable, int[] linearVector) {
        this.lable = lable;
        this.linearVector = linearVector;
    }

    public Integer getLable() {
        return this.lable;
    }

    public int[] getLinearVector() {
        return this.linearVector;
    }

    public double getLenght() {
        double result = 0;
        int[] coord = getLinearVector();
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(coord[coordinate] - coord[coordinate + 1], 2);
        }
        return Math.sqrt(result);
    }

    public double getWeight() {
        double result = 0;
        int[] coord = getLinearVector();
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(coord[coordinate], 2);
        }
        return Math.sqrt(result);
    }

    public double getDifference(DataJPG dataJPG) {
        double result = 0;
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(getLinearVector()[coordinate] - dataJPG.getLinearVector()[coordinate], 2);
        }
        return Math.sqrt(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataJPG dataJPG = (DataJPG) o;
        return Objects.equals(lable, dataJPG.lable)
                && Arrays.equals(linearVector, dataJPG.linearVector);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(lable);
        result = 31 * result + Arrays.hashCode(linearVector);
        return result;
    }

    @Override
    public String toString() {
        return "DataJPG { "
                + " lable="
                + lable
                + '}';
    }
}
