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
		
		int[][] myMatrix = new int[size+1][size+1];
		for(int row = 0; row <  size+1; row++){
			for(int column = 0; column < size+1; column++){
				myMatrix[row][column] = row*column;
				if(row == 0) {myMatrix[row][column] = column;}
				if(column == 0) {myMatrix[row][column] = row;}
			}
		}
		return myMatrix;
	}

    /**
     * матрица без полей
     * @param size
     * @return
     */
	public int[][] multipleWithoutTableFields(int size) {

		int[][] myMatrix = new int[size][size];
		for(int row = 0; row <  size; row++){
			for(int column = 0; column < size; column++){
				myMatrix[row][column] = (row+1)*(column+1);
			}
		}
		return myMatrix;
	}
}