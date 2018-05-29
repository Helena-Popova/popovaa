package banktransfers.implementation;
import banktransfers.operands.*;

import java.util.List;

abstract class Bank {

    abstract void addUser(User user);

    abstract void deleteUser(User user);

    abstract void addAccountToUser(String passport, Account account);

    abstract void deleteAccountFromUser(String passport, Account account);

    abstract List<Account> getUserAccounts(String passport);

    abstract boolean transferMoney(String srcPassport, Requisites srcRequisite, String destPassport, Requisites dstRequisite, double amount);
}
