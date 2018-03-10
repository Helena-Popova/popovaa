package ru.job4j.array;

/**
 * @author Helena
 * @version 1.0
 * @since 10.03.2018
*/

public class FindLoop {

	/**
	 * Method for find an element
	 * @param data
	 * @param element
	 * @return result
	 */
	public int indexOf(int[] data, int element) {
		int result = -1;
		for(int index = 0; index < data.length ; index++){
			if(data[index] == element){
				result = index;
				break;
			}
		}
		return result;
	}



}