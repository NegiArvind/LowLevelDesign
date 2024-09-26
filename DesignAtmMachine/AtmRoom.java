import models.Atm;
import models.Card;
import models.TransactionType;
import models.User;
import models.UserBankAccount;

public class AtmRoom {

    private Atm atm;
    private User user;

    public static void main(String[] args) {
        AtmRoom atmRoom = new AtmRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentAtmStatus();
        atmRoom.atm.getCurrentAtmState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentAtmState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), "112113");
        atmRoom.atm.getCurrentAtmState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentAtmState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printCurrentAtmStatus();

        // balance check
        atmRoom.atm.printCurrentAtmStatus();
        atmRoom.atm.getCurrentAtmState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentAtmState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), "112113");
        atmRoom.atm.getCurrentAtmState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.BALANCE_CHECK);
        atmRoom.atm.getCurrentAtmState().displaceBalance(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.printCurrentAtmStatus();
    }

    private void initialize() {
        atm = Atm.getAtmObject();
        atm.setAtmBalance(3500,1,2,5);
        user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBalance(3000);
        bankAccount.setUserName("Arvind");
        bankAccount.setAccountNumber("657432418970");
        bankAccount.setWithdrawalLimit(1000000);
        return bankAccount;
    }

}
