package VendingStates;

import models.Coin;
import models.Item;
import models.VendingMachine;

import java.util.List;

public interface State {

    void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;

    void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;

    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;

    Item chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    int getChange(int returnExtraMoney) throws Exception;

    Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;

    void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;

}
