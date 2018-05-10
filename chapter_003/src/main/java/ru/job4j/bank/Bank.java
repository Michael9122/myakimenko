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
     * Добавить счёт пользователю.
     * @param passport паспорт.
     * @param account номер счета.
     */
    public void addAccountToUser(String passport, Account account) {
        for (User i : users.keySet()) {
            if (i.getPassport().equals(passport)) {
                users.get(i).add(account);
            }
        }
    }

    /**
     * Удалить один счёт пользователя.
     * @param passport паспорт.
     * @param account номер счета.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User i : users.keySet()) {
            if (i.getPassport().equals(passport)) {
                users.get(i).remove(account);
            }
        }
    }

    /**
     * Получить список счетов для пользователя.
     * @param passport паспорт.
     * @return счет пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                result = this.users.get(key);
            }
        }
        return result;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * @param srcPassport паспорт отправителя.
     * @param srcRequisite реквизиты отправителя.
     * @param destPassport паспорт получателя.
     * @param dstRequisite реквизиты получателя.
     * @param amount сумма перевода.
     * @return вернуть true если перевод возможен, либо false если нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, int amount) {
        boolean src = false;
        boolean dst = false;
        boolean trans = false;
        List<Account> srcList = getUserAccounts(srcPassport);
        List<Account> dstList = getUserAccounts(destPassport);
        for (Account account : srcList) {
            if (account.getRequisites().equals(srcRequisite)) {
                src = true;
                srcList = Arrays.asList(account);
            }
        }
        for (Account account : dstList) {
            if (account.getRequisites().equals(dstRequisite)) {
                dst = true;
                dstList = Arrays.asList(account);
            }
        }
        if ((src && dst) && (srcList.get(0).transfer(dstList.get(0), amount))) {
            trans = true;
        }
        return trans;
    }
}
