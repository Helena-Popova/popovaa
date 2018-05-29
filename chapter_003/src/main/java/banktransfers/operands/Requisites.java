package banktransfers.operands;

import java.util.Objects;

public class Requisites {
    /**
     * ИНН клиента
     */
    private String userTIN;

    /**
     * КПП клиента
     */
    private String userCPR;

    /**
     *  Двадцатизначный номер банковского счета. Расчетный счет.
     */
    private String bankAccountNumber;

    /**
     * БИК банка, где у клиента открыт счет
     */
    private String bankBIC;

    public static final Requisites EMPTY = new Requisites();

    public Requisites() {
        this.bankBIC = null;
        this.userTIN = null;
        this.userCPR = null;
        this.bankAccountNumber = null;
    }

    public Requisites(String bankBIC) {
        this.bankBIC = bankBIC;
        this.userTIN = "default";
        this.userCPR = "default";
        this.bankAccountNumber = "default";

    }

    public Requisites(String userTIN, String userCPR, String bankAccountNumber, String bankBIC) {
        this.userTIN = userTIN;
        this.userCPR = userCPR;
        this.bankAccountNumber = bankAccountNumber;
        this.bankBIC = bankBIC;
    }

    public String getUserTIN() {
        return userTIN;
    }

    public void setUserTIN(String userTIN) {
        this.userTIN = userTIN;
    }

    public String getUserCPR() {
        return userCPR;
    }

    public void setUserCPR(String userCPR) {
        this.userCPR = userCPR;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankBIC() {
        return bankBIC;
    }

    public void setBankBIC(String bankBIC) {
        this.bankBIC = bankBIC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requisites that = (Requisites) o;
        return Objects.equals(userTIN, that.userTIN) &&
                Objects.equals(userCPR, that.userCPR) &&
                Objects.equals(bankAccountNumber, that.bankAccountNumber) &&
                Objects.equals(bankBIC, that.bankBIC);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userTIN, userCPR, bankAccountNumber, bankBIC);
    }

    @Override
    public String toString() {
        return bankBIC;
    }
}
