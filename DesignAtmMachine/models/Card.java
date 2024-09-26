package models;

import java.util.Date;

public class Card {

    private String cardNumber;
    private String cvv;
    private Date expiryDate;
    private String holderName;

    static String pin_number = "112113";

    UserBankAccount userBankAccount;

    public boolean isCorrectPinEntered(String enteredPin) {
        return pin_number.equals(enteredPin);
    }

    public int getBankBalance() {
        return userBankAccount.balance;
    }

    public void deductBankBalance(int amount) {
        userBankAccount.withdrawBalance(amount);
    }

    public void setBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }




}
