package atmStates.impl;

import atmStates.AtmState;
import atmStates.impl.IdleState;
import models.Atm;
import models.Card;
import models.TransactionType;

public class SelectOperationState implements AtmState {

    @Override
    public void selectOperation(Atm atm, Card card, TransactionType type) {
        if(type == TransactionType.BALANCE_CHECK) {
            System.out.println("You have selected balance check");
            atm.setCurrentAtmState(new CheckBalanceState());
        } else if(type == TransactionType.CASH_WITHDRAWAL){
            System.out.println("You have selected cash withdrawal");
            atm.setCurrentAtmState(new CashWithdrawalState());
        }
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setCurrentAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
}
