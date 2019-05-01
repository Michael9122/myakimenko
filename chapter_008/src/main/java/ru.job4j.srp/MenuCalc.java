package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 01.05.2019
 */
public class MenuCalc {

    private Input input;

    private Calculator calc;

    private List<UserAction> actions = new ArrayList<>();

    public MenuCalc(Input input, Calculator calc) {
        this.input = input;
        this.calc = calc;
    }

    public void fillActions() {
        this.actions.add(new Add(1, "Addition"));
        this.actions.add(new Subtract(2, "Subtraction"));
        this.actions.add(new Multiple(3, "Multiplication"));
        this.actions.add(new Div(4, "Division"));
    }

    public int getRange() {
        return actions.size();
    }

    public void selectAction(int key) {
        this.actions.get(key - 1).execute(this.input, this.calc);
    }

    public void runMenu() {
        do {
            int[] range = new int[getRange()];
            for (int i = 0; i < range.length; i++) {
                range[i] = i;
            }
            showMenu();
            selectAction(input.ask("Please select action: ", range));
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
    }

    public void showMenu() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class Add extends BaseAction {
        public Add(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Calculator calculator) {
            double first = Double.valueOf(input.ask("Enter first number:"));
            double second = Double.valueOf(input.ask("Enter second number:"));
            calculator.add(first, second);
            System.out.println(calculator.getResult());
        }
    }

    private class Subtract extends BaseAction {
        public Subtract(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Calculator calculator) {
            double first = Double.valueOf(input.ask("Enter first number:"));
            double second = Double.valueOf(input.ask("Enter second number:"));
            calculator.subtract(first, second);
            System.out.println(calculator.getResult());
        }
    }

    private class Multiple extends BaseAction {
        public Multiple(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Calculator calculator) {
            double first = Double.valueOf(input.ask("Enter first number:"));
            double second = Double.valueOf(input.ask("Enter second number:"));
            calculator.multiple(first, second);
            System.out.println(calculator.getResult());
        }
    }

    private class Div extends BaseAction {
        public Div(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Calculator calculator) {
            double first = Double.valueOf(input.ask("Enter first number:"));
            double second = Double.valueOf(input.ask("Enter second number:"));
            calculator.div(first, second);
            System.out.println(calculator.getResult());
        }
    }
}
