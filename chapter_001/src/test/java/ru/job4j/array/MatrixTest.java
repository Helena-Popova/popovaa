package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MatrixTest {
    /**
     * Тест с полями,чтобы было выдно что на что перемножается.
     * соответсвенное, если матрица для 4, то размер ее будет пять.
     * потому что 1 столбец и 1 строка это поля .
     */
    @Test
    public void checkMyMatrixForSizeFour() {
        int[][] checkMatrix = {
                {0, 1, 2, 3, 4},
                {1, 1, 2, 3, 4},
                {2, 2, 4, 6, 8},
                {3, 3, 6, 9, 12},
                {4, 4, 8, 12, 16}
        };
        Matrix multiplicationTable = new Matrix();
        int[][] resultMatrix = multiplicationTable.multiple(4);
        assertThat(resultMatrix, is(checkMatrix));
    }

    /**
     * тест для матрицы без полей
     */
    @Test
    public void checkMyMatrixForSizeFive() {
        int[][] checkMatrix = {
                {1, 2, 3, 4, 5},
                {2, 4, 6, 8, 10},
                {3, 6, 9, 12, 15},
                {4, 8, 12, 16, 20},
                {5, 10, 15, 20, 25}
        };
        Matrix multiplicationTable = new Matrix();
        int[][] resultMatrix = multiplicationTable.multipleWithoutTableFields(5);
        assertThat(resultMatrix, is(checkMatrix));
    }

}