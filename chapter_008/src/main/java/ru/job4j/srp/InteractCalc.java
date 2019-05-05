package ru.job4j.srp;

import ru.job4j.ocp.TrigonometryCalc;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 30.04.2019
 */
public class InteractCalc {

    private Input input;

    private TrigonometryCalc calculator;


    public InteractCalc(Input input, TrigonometryCalc calculator) {
        this.input = input;
        this.calculator = calculator;
    }

    void init() {
        MenuCalc menu = new MenuCalc(this.input, this.calculator);
        menu.fillActions();
        menu.runMenu();
    }

    public static void main(String[] args) {
        new InteractCalc(new ValidateInput(new ConsoleInput()), new TrigonometryCalc()).init();
    }
}