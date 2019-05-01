package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 01.05.2019
 */
public interface UserAction {

    int key();

    void execute(Input input, Calculator calculator);

    String info();
}
