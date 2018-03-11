package ru.job4j.array;

/**
 * @author Helena
 * @version 1.0
 * @since 09.03.2018
*/

public class Square {
	
/**
*/
	public int[] calculate(int bound) {
		int[] result = new int[bound];
		for (int i = 0; i < result.length; i++) {
			result[i] = i * i;
		}
		return result;
	}
}