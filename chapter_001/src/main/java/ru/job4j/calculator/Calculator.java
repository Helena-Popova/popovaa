package ru.job4j.calculator;

public class Calculator{
	double result = 0;
	
	public void add(double first, double second) {
		this.result = first + second;
	}
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	public void div(double first, double second) {
		this.result = first/second;
	}
	public void multiple(double first, double second) {
		this.result = first + second;
	}
	
	public double getResult() {
		return this.result;
	}
	
}