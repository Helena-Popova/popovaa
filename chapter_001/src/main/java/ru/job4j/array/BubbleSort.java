package ru.job4j.array;

/**
 * @author Helena
 * @version 1.0
 * @since 10.03.2018
*/

public class BubbleSort {

	/**
	 * method for sort
	 * @param array
	 * @return sorted array
	 */
	
	public int[] sort(int[] array) {
		
		int numberOfPasses = array.length;
		while(numberOfPasses > 1){
			for(int index = 0; index < numberOfPasses-1; index++){
				if(array[index] > array[index+1]){
				int temp = array[index+1];
				array[index + 1] = array[index];
				array[index] = temp;
				}
			}
			--numberOfPasses;
		}
		
		return array;
	}
}