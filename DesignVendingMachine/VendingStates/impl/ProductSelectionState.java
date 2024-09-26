package VendingStates.impl;

import VendingStates.State;
import models.Coin;
import models.Item;
import models.VendingMachine;

import java.util.List;

public class ProductSelectionState implements State {

    public ProductSelectionState() {
        System.out.println("Currently vending machine is in selection state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("you can not insert Coin in selection state");
    }

    @Override
    public Item chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item= vendingMachine.getInventory().getItem(codeNumber);

        // Total amount paid by user
        int paidByUser = 0;
        for(Coin coin: vendingMachine.getCoinList()) {
            paidByUser = paidByUser + coin.value;
        }

        // if paidByUser is less than product price
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new Exception("insufficient amount");
        } else if(paidByUser >= item.getPrice()){
            if(paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new ProductDispenseState(vendingMachine, codeNumber));
        }
        return item;
    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception {
        //actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
