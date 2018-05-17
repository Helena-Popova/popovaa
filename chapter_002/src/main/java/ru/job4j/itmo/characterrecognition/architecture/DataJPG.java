package ru.job4j.itmo.characterrecognition.architecture;
import java.util.Arrays;
import java.util.Objects;

public class DataJPG {
    private int lable;
    private int[] linearVector;

    public DataJPG(int lable, int[] linearVector) {
        this.lable = lable;
        this.linearVector = linearVector;
    }

    /**
     * Значение цифры на картинке
     * @return цифра от 1 до 9
     */
    public Integer getLable() {
        return this.lable;
    }

    /**
     * Пооучаем картинку в виде вектора.
     * Преобразование происходит в классе Loader:
     * картинка представляет собой матрицу 28 на 28 бита.
     * эта матрица построчно переводится в одну строку длинй 784 бита,
     * с битами стоящими друг за другом.
     * Каждый бит переводится в значение int - интенсивность цвета от от -128 до 127.
     * Пояснение:
     * значения цветов в исходных данных на картинке —
     * это беззнаковые байты (0-255), в то время как в Java байт знаковый (от -128 до 127).
     * Можно беззнаковые байты перевести в знаковый int:
     * int a = b & 0xff
     * @return вектор
     */
    public int[] getLinearVector() {
        return this.linearVector;
    }

    /**
     * Считает длину вектора , который представляет собой картинку
     * @return длина вектора
     */
    public double getLenght() {
        double result = 0;
        int[] coord = getLinearVector();
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(coord[coordinate] - coord[coordinate + 1], 2);
        }
        return Math.sqrt(result);
    }

    /**
     * высчитывает вес функции описанной вектором
     * @return
     */
    public double getWeight() {
        double result = 0;
        int[] coord = getLinearVector();
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(coord[coordinate], 2);
        }
        return Math.sqrt(result);
    }

    /**
     * Высчитывает разницу между двумя веткорами
     * @param dataJPG вектор с которым нужно посчитать разницу
     * @return разница между векторами
     */
    public double getDifference(DataJPG dataJPG) {
        double result = 0;
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(getLinearVector()[coordinate] - dataJPG.getLinearVector()[coordinate], 2);
        }
        return Math.sqrt(result);
    }

    /**
     * Получаем скалярное произведение векторов с дркгим вектором dataJPG
     * @param dataJPG вектор с которым производим операцию
     * @return скалярное приизведение
     */
    public double getScalar(DataJPG dataJPG) {
        double result = 0;
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += this.getLinearVector()[coordinate] * dataJPG.getLinearVector()[coordinate];
        }

        return result;
    }

    /**
     * Получить модуль вектора
     * @return модуль вектора
     */
    public double getModule() {
        double result = 0;
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(this.getLinearVector()[coordinate], 2);
        }
        return Math.sqrt(result);
    }

    /**
     * Для метода распознавания картинки по минимальному углу между векторами, то есть углу до ближайшего соседа нам нужен косинус угла до соседа
     * @param dataJPG сосед
     * @return косинус угла между this и  dataJPG
     */
    public double getCos(DataJPG dataJPG) {
        double result = this.getScalar(dataJPG) / (this.getModule() * dataJPG.getModule());
        return Math.acos(result);
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

    /**
     * Выводит число, которым индетенфицированна картинка в библиотеке MNIST
     * @return - лейбл
     */
    @Override
    public String toString() {
        return "DataJPG { "
                + " lable="
                + lable
                + '}';
    }
}
