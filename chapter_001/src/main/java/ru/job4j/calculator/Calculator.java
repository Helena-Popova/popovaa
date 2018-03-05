package ru.job4j.calculator;

/**
 * Простейший калькулятор.
 * @author Popova Alena
 * @version $Id$
 * @since 0.1
 */

public class Calculator{
	/**
	 * поле внутреней переменной
	 */
	private double result = 0;

	/**
	 * Метод операции сложения.
	 * @param first
	 * @param second
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 * Метод операции вычитания.
	 * @param first
	 * @param second
	 */
	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	 * Метод операции деления.
	 * @param first
	 * @param second
	 */
	public void div(double first, double second) {
		this.result = first/second;
	}

	/**
	 * Метод операции уножения.
	 * @param first
	 * @param second
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 *
	 * @return result of calculating
	 */
	public double getResult() {
		return this.result;
	}

}