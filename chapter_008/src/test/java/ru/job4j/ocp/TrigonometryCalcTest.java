package ru.job4j.ocp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrigonometryCalcTest {

    @Test
    public void sin() {
        TrigonometryCalc calc = new TrigonometryCalc();
        calc.sin(30);
        assertThat(calc.result, is(Math.sin(30)));
    }

    @Test
    public void cos() {
        TrigonometryCalc calc = new TrigonometryCalc();
        calc.cos(30);
        assertThat(calc.result, is(Math.cos(30)));
    }
}