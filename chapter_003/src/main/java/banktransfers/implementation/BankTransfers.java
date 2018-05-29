package banktransfers.implementation;
import banktransfers.exceptions.TransferError;
import banktransfers.operands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankTransfers extends Bank {
    private Map<User, List<Account>> bankData = new HashMap<>();

    public Map<User, List<Account>> getBankData() {
        return bankData;
    }

    @Override
    void addUser(User user) {
        if(!this.bankData.containsKey(user)) {
            this.bankData.put(user, new ArrayList<Account>());
        } else {
            throw new TransferError(" Такой пользователь уже существует ");
        }
    }

    @Override
    void deleteUser(User user) {
        if(this.bankData.containsKey(user)) {
            this.bankData.remove(user);
        } else {
            throw new TransferError(" Такого пользователя еще не существует ");
        }
    }

    @Override
    void addAccountToUser(String passport, Account account) {
        User user = findByPassport(passport);
        if ( user != User.EMPTY) {
            this.bankData.get(user).add(account);
        }
    }

    @Override
    void deleteAccountFromUser(String passport, Account account) {
        User user = findByPassport(passport);
        if ( user != User.EMPTY) {
            this.bankData.get(user).remove(account);
        }
    }

    @Override
    List<Account> getUserAccounts(String passport) {
        User user = findByPassport(passport);
        List<Account> result =  user != User.EMPTY ? this.bankData.get(user) : new ArrayList<>();
        return result;
    }

    /**
     * Mетод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param dstRequisite
     * @param amount
     * @return
     */
    @Override
    boolean transferMoney(String srcPassport, Requisites srcRequisite, String destPassport, Requisites dstRequisite, double amount) {
        boolean result = false;
        User src = findByPassport(srcPassport);
        User dest = findByPassport(destPassport);
        if (src != User.EMPTY && dest != User.EMPTY) {
            int indexSrc  = this.bankData.get(src).indexOf(findAccountByRequisite(src,srcRequisite));
            int indexDest = this.bankData.get(src).indexOf(findAccountByRequisite(dest,dstRequisite));
            double value = this.bankData.get(src).get(indexSrc).getValue();
            if (value > amount) {
                this.bankData.get(src).get(indexSrc).setValue(value - amount);
                this.bankData.get(dest).get(indexDest).setValue(value + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Найти юзера по Passport
     * @param passport
     * @return
     */
    private User findByPassport(String passport) {
        User result = User.EMPTY;
        for (User user : bankData.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Найти нужный счет у юзера, если его нет, вернуть Account.EMPTY.
     * @param aRequisite
     * @return
     */
    private Account findAccountByRequisite(User user, Requisites aRequisite) {
        List<Account> list =  this.bankData.get(user);
        Account result = Account.EMPTY;
        for (Account account : list) {
            if (account.getRequisites().equals(aRequisite)) {
                result = account;
                break;
            }
        }
        return result;
    }
}