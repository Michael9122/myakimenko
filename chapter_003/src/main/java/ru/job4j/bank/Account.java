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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (value != account.value) return false;
        return requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + requisites.hashCode();
        return result;
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
