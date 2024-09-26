package amountWithdrawal;

import models.Atm;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(Atm atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if(requiredNotes <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(requiredNotes);
        } else {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (requiredNotes - atm.getNoOfFiveHundredNotes()) * 500;
        }
        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
