package atmStates.impl;

import amountWithdrawal.CashWithdrawProcessor;
import amountWithdrawal.FiveHundredWithdrawProcessor;
import amountWithdrawal.OneHundredWithdrawProcessor;
import amountWithdrawal.TwoThousandWithdrawProcessor;
import atmStates.AtmState;
import models.Atm;
import models.Card;

public class CashWithdrawalState implements AtmState {

    @Override
    public void cashWithdrawal(Atm atm, Card card, int withDrawAmount) {
        if(atm.getAtmBalance() < withDrawAmount) {
            System.out.println("Insufficient balance in the ATM");
            exit(atm);
        } else if(card.getBankBalance() < withDrawAmount) {
            System.out.println("Insufficient balnce in your account");
            exit(atm);
        } else {
            card.deductBankBalance(withDrawAmount);
            atm.deductAtmBalance(withDrawAmount);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor cashWithdrawProcessor = new TwoThousandWithdrawProcessor(
                    new FiveHundredWithdrawProcessor(
                            new OneHundredWithdrawProcessor(null)
                    )
            );
            cashWithdrawProcessor.withdraw(atm, withDrawAmount);
            System.out.println("Amount has been successfully dispensed");
            exit(atm);
        }
    }

    @Override
    public void exit(Atm atm) {
        atm.setCurrentAtmState(new IdleState());
        returnCard();
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
