package ru.job4j.bank;

import java.util.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 06.05.2018
 * @version 1
 */
public class Bank {

    private Map<User, List<Account>> users = new TreeMap<>();

    /**
     * Добавление пользователя.
     * @param user пользователь.
     */
    public void addUser(User user) {
        this.users.put(user, new ArrayList<>());
    }

    /**
     * Удаление пользователя.
     * @param user пользователь.
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Поиск нужного пользователя.
     * @param passport паспорт пользователя.
     * @return найденого пользвателя.
     */
    public User findUser(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }
    /**
     * Добавить счёт пользователю.
     * @param passport паспорт.
     * @param account номер счета.
     */
    public void addAccountToUser(String passport, Account account) {
        users.get(findUser(passport)).add(account);
    }

    /**
     * Удалить один счёт пользователя.
     * @param passport паспорт.
     * @param account номер счета.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        users.get(findUser(passport)).remove(account);
    }

    /**
     * Получить список счетов для пользователя.
     * @param passport паспорт.
     * @return счет пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = users.get(findUser(passport));
        return result;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * @param srcPassport паспорт отправителя.
     * @param destPassport паспорт получателя.
     * @param amount сумма перевода.
     * @return вернуть true если перевод возможен, либо false если нет.
     */
    public boolean transferMoney(String srcPassport, String destPassport, int amount) {
        boolean src = false;
        boolean dst = false;
        boolean trans = false;
        List<Account> srcList = getUserAccounts(srcPassport);
        List<Account> dstList = getUserAccounts(destPassport);
        if (srcList != null) {
            src = true;
        }
        if (dstList != null) {
            dst = true;
        }
        if ((src && dst) && (srcList.get(0).transfer(dstList.get(0), amount))) {
            trans = true;
        }
        return trans;
    }
}
