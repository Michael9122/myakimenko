package ru.job4j.bank;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 06.05.2018
 * @version 1
 */
public class BankTest {

    /**
     * Добавление аккаунта пользователю.
     */
    @Test
    public void whenAddAccountToUserThenAdd() {
        Bank bank = new Bank();
        User user = new User("Michael", "5520");
        Account account = new Account(100, "456");
        bank.addUser(user);
        bank.addAccountToUser("5520", account);
        assertThat(bank.getUserAccounts("5520"), is(Arrays.asList(account)));
    }

    /**
     * Удаление аккаунта у пользьвателя.
     */
    @Test
    public void deleteAccountFromUserThenDeleteAccount() {
        Bank bank = new Bank();
        User user = new User("Michael", "5520");
        bank.addUser(user);
        Account accountOne = new Account(150, "789");
        Account accountTwo = new Account(100, "456");
        bank.addAccountToUser("5520", accountOne);
        bank.addAccountToUser("5520", accountTwo);
        bank.deleteAccountFromUser("5520", accountOne);
        assertThat(bank.getUserAccounts("5520"), is(Arrays.asList(accountTwo)));
    }
    /**
     * Перевод денег на второй аккаунт, когда денег хватает.
     */
    @Test
    public void whenTransferMoneyAmountSameUserAccountsThenTrue() {
        Bank bank = new Bank();
        User user = new User("Michael", "5520");
        bank.addUser(user);
        Account accountOne = new Account(150, "789");
        Account accountTwo = new Account(100, "456");
        bank.addAccountToUser("5520", accountOne);
        bank.addAccountToUser("5520", accountTwo);
        boolean result = bank.transferMoney(
                "5520",
                "789",
                "5520",
                "456",
                50
        );
        assertThat(result, is(true));
    }
    /**
     * Перевод денег на аккаунт другого пользователя, когда денег хватает.
     */
    @Test
    public void whenTransferMoneyAmountDifferentUserAccountsThenTrue() {
        Bank bank = new Bank();
        User userOne = new User("Michael", "5520");
        User userTwo = new User("Ivan", "5510");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        Account accountOne = new Account(150, "789");
        Account accountTwo = new Account(100, "456");
        bank.addAccountToUser("5520", accountOne);
        bank.addAccountToUser("5510", accountTwo);
        boolean result = bank.transferMoney(
                "5520",
                "789",
                "5510",
                "456",
                50
        );
        assertThat(result, is(true));
    }
    /**
     * Перевод денег на аккаунт другого пользователя, когда денег не хватает.
     */
    @Test
    public void whenTransferMoneyAmountDifferentUserAccountsThenFalse() {
        Bank bank = new Bank();
        User userOne = new User("Michael", "5520");
        User userTwo = new User("Ivan", "5510");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        Account accountOne = new Account(150, "789");
        Account accountTwo = new Account(100, "456");
        bank.addAccountToUser("5520", accountOne);
        bank.addAccountToUser("5510", accountTwo);
        boolean result = bank.transferMoney(
                "5520",
                "789",
                "5510",
                "456",
                160
        );
        assertThat(result, is(false));
    }
}