package ru.job4j.array;

/**
 * @author Helena
 * @version 1.0
 * @since 10.03.2018
*/
public class Matrix {

	/**
	 * multiplication table
     * марица с полями
	 * @param size
	 * @return myMatrix
	 */
	
	public int[][] multiple(int size) {
		size = size + 1;
		int[][] myMatrix = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				myMatrix[row][column] = (row == 0 || column == 0) ? column + row : row * column;
			}
		}
		return myMatrix;
	}

    /**
     * матрица без полей.
     * @param size
     * @return
     */
	public int[][] multipleWithoutTableFields(int size) {

		int[][] myMatrix = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				myMatrix[row][column] = (row + 1) * (column + 1);
			}
		}
		return myMatrix;
	}
}