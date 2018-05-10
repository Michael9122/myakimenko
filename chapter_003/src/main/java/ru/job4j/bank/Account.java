package ru.job4j.bank;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 06.05.2018
 * @version 1
 */
public class Account extends Object {
    private int value;
    private String requisites;

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public boolean transfer(Account destination, int amount) {
        boolean result = false;
        if (amount > 0 && amount < this.value && destination != null) {
            result = true;
            this.value -= amount;
            destination.value += amount;
        }
        return result;
    }
}
