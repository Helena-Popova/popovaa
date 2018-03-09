package ru.job4j.array;

/**
 * @author Helena
 * @version 1.0
 * @since 09.03.2018
*/

public class Square {
	
/**
*/
	public int[] calculate(int bound){
		int[] rslt = new int[bound];
		for(int i = 0; i < rslt.length; i++){
			rslt[i] = i*i;
		}
		return rslt;
	}
}