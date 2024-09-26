package amountWithdrawal;

import models.Atm;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;
    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        this.nextCashWithdrawProcessor = cashWithdrawProcessor;
    }

    public void withdraw(Atm atm, int remainingAmount) {
        if(nextCashWithdrawProcessor != null) {
            nextCashWithdrawProcessor.withdraw(atm, remainingAmount);
        }
    }
}
