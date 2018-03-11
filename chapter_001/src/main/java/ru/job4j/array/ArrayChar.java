package ru.job4j.array;

/**
 * @author Helena
 * @version 1.0
 * @since 10.03.2018
*/
public class ArrayChar {
	private char[] data;
	
	public ArrayChar(String line) {
		this.data = line.toCharArray();
		
	}
	
	public boolean startWith(String prifix) {
		boolean result = true;
		
		char[] value = prifix.toCharArray();
		for (int index = 0; index < prifix.length(); index++){
			if(this.data[index] != value[index]){
				result = false;
			}
		}
		// проверить
		return result;
	}


}