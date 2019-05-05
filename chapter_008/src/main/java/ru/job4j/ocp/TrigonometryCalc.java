package ru.job4j.ocp;

import ru.job4j.calculator.Calculator;

public class TrigonometryCalc extends Calculator {

    public double result;

    public void sin(double a) {
        result = Math.sin(a);
    }

    public void cos(double a) {
        result = Math.cos(a);
    }
}
