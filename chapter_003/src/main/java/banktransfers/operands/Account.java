package banktransfers.operands;

import java.util.Objects;

public class Account {
    private double value;
    private Requisites requisites;

    public static final Account EMPTY = new Account();

    public Account() {
        this.value = 0;
        this.requisites = Requisites.EMPTY;
    }

    public Account(long value, Requisites requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Requisites getRequisites() {
        return requisites;
    }

    public void setRequisites(Requisites requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return value == account.value &&
                Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, requisites);
    }

    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", requisites=" + requisites.toString() +
                '}';
    }
}
