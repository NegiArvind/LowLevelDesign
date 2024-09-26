package amountWithdrawal;

import models.Atm;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {

    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(Atm atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if(requiredNotes <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandsNotes(requiredNotes);
        } else {
            atm.deductTwoThousandsNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (requiredNotes - atm.getNoOfTwoThousandNotes()) * 2000;
        }
        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
