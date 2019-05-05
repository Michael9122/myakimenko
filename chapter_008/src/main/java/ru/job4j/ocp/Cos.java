package ru.job4j.ocp;

import ru.job4j.srp.BaseAction;
import ru.job4j.srp.Input;

public class Cos extends BaseAction {

        public Cos(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, TrigonometryCalc calculator) {
            double a = Double.valueOf(input.ask("Enter the angle: "));
            calculator.cos(a);
            System.out.println(calculator.result);
        }
}
