package ru.job4j.calculator;

/**
 * Класс для сложения, вычетания, умножения и деления.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.02.2018
 * @version 1
 */
public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    public void div(double first, double second) {
        this.result = first / second;
    }
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    public double getResult() {
        return this.result;
    }
}
