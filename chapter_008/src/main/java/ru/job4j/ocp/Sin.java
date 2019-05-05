package ru.job4j.ocp;

import ru.job4j.srp.BaseAction;
import ru.job4j.srp.Input;

public class Sin extends BaseAction {

    public Sin(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, TrigonometryCalc calculator) {
        double a = Double.valueOf(input.ask("Enter the angle: "));
        calculator.sin(a);
        System.out.println(calculator.result);
    }
}

