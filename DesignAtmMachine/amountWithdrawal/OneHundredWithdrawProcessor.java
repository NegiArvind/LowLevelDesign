package amountWithdrawal;

import models.Atm;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {

    public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(Atm atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if(requiredNotes <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(requiredNotes);
        } else {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (requiredNotes - atm.getNoOfOneHundredNotes()) * 500;
        }
        if(balance != 0) {
            System.out.println("Something went wrong");
        }
    }
}
