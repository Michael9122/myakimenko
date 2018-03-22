package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.03.2018
 * @version 1
 */
public class CoffeeMachineTest {

    @Test
    public void whenGiveFiftyAndPriceThirtyTwoThenTenFiveTwoOneCoins() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 32);
        int[] expected = new int[] {10, 5, 2, 1};
        assertThat(result, is(expected));
    }
}
