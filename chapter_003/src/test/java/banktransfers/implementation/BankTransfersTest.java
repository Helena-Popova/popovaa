package banktransfers.implementation;

import banktransfers.operands.Account;
import banktransfers.operands.Requisites;
import banktransfers.operands.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTransfersTest {

    BankTransfers bankTransfers = new BankTransfers();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * на доске имеются изначально две фигуры
     */
    @Before
    public void loadMem() {

    }

    @Test
    public void addUser() {
        bankTransfers.addUser(new User("12 34 5678"));
        assertThat(new User("12 34 5678"), is(bankTransfers.getBankData().keySet().iterator().next()));
    }

    @Test
    public void deleteUser() {
        bankTransfers.addUser(new User("12 34 5678"));
        bankTransfers.deleteUser(new User("12 34 5678"));
        assertTrue(bankTransfers.getBankData().isEmpty());

    }

    @Test
    public void addAccountToUser() {
        bankTransfers.addUser(new User("12 34 5678"));
        Requisites requisites = new Requisites("044525256");
        bankTransfers.addAccountToUser("12 34 5678", new Account(100, requisites));
        assertThat(new Account(100, requisites), is(bankTransfers.getBankData().get(new User("12 34 5678")).get(0)));
    }

    @Test
    public void deleteAccountFromUser() {
        bankTransfers.addUser(new User("12 34 5678"));
        Requisites sber = new Requisites("044525256");
        Requisites vtb = new Requisites("333525256");
        bankTransfers.addAccountToUser("12 34 5678", new Account(100, sber));
        bankTransfers.addAccountToUser("12 34 5678", new Account(200, vtb));
        bankTransfers.deleteAccountFromUser("12 34 5678", new Account(100, sber));
        assertTrue(bankTransfers.getBankData().size() == 1);
        assertThat(new Account(200, vtb), is(bankTransfers.getBankData().get(new User("12 34 5678")).get(0)));
    }

    @Test
    public void getUserAccounts() {
        List<Account> accounts = new ArrayList<>();

        bankTransfers.addUser(new User("12 34 5678"));
        Requisites sber = new Requisites("044525256");
        Requisites vtb = new Requisites("333525256");
        bankTransfers.addAccountToUser("12 34 5678", new Account(100, sber));
        bankTransfers.addAccountToUser("12 34 5678", new Account(200, vtb));

        accounts.add( new Account(100, sber));
        accounts.add( new Account(200, vtb));

        assertThat(accounts, is(bankTransfers.getUserAccounts("12 34 5678")));

    }

    @Test
    public void transferMoney() {
        bankTransfers.addUser(new User("12 34 5678"));
        Requisites sber = new Requisites("044525256");
        Requisites vtb = new Requisites("333525256");
        bankTransfers.addAccountToUser("12 34 5678", new Account(100, sber));
        bankTransfers.addAccountToUser("12 34 5678", new Account(200, vtb));

        boolean result = bankTransfers.transferMoney("12 34 5678", sber, "12 34 5678", vtb, 50);
        assertTrue(result);
    }

    @Test
    public void transferMoneyThanValueOnAccountLessThenNeed() {
        bankTransfers.addUser(new User("12 34 5678"));
        Requisites sber = new Requisites("044525256");
        Requisites vtb = new Requisites("333525256");
        bankTransfers.addAccountToUser("12 34 5678", new Account(100, sber));
        bankTransfers.addAccountToUser("12 34 5678", new Account(200, vtb));

        boolean result = bankTransfers.transferMoney("12 34 5678", sber, "12 34 5678", vtb, 150);
        assertFalse(result);
    }
}