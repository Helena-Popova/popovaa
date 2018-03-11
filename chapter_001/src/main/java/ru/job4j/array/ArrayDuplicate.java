package ru.job4j.array;
 import java.util.Arrays;

/**
 * @author Helena
 * @version 1.0
 * @since 10.03.2018
*/

public class ArrayDuplicate {
	/**
	 * metod for remove dublicate
	 * @param array
	 * @return array with deleted duplicates
	 */
	public String[] remove(String[] array) {
		
		int repeatCounter = array.length - 1;
			for (int index = 0; index < array.length; index++) {
				String temp = array[index];
				for (int indexCompare = index + 1; indexCompare < repeatCounter;) {
					if (temp.equals(array[indexCompare])) {
						array[indexCompare] = array[repeatCounter];
						repeatCounter--;
					}
					else {
						indexCompare++;
					}
					
				}
			}
			return Arrays.copyOf(array, repeatCounter);
	}
}