import VendingStates.State;
import models.Coin;
import models.Item;
import models.ItemShelf;
import models.ItemType;
import models.VendingMachine;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            System.out.println("|");
            System.out.println("Item dispensed successfully");
            System.out.println("|");

            displayInventory(vendingMachine);
        } catch (Exception exception) {
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        List<ItemShelf> itemShelfList = vendingMachine.getInventory().getInventory();
        System.out.println("item self list size -> " + itemShelfList.size());
        for(int i = 0; i < itemShelfList.size(); i++) {
            Item newItem = getItem(i);
            itemShelfList.get(i).setItem(newItem);
            itemShelfList.get(i).setSoldOut(false);
        }
    }

    private static Item getItem(int i) {
        Item newItem = new Item();
        if(i < 3) {
            newItem.setType(ItemType.COKE);
            newItem.setPrice(12);
        } else if(i < 5) {
            newItem.setType(ItemType.PEPSI);
            newItem.setPrice(9);
        } else if(i < 7) {
            newItem.setType(ItemType.JUICE);
            newItem.setPrice(13);
        } else if(i < 10) {
            newItem.setType(ItemType.SODA);
            newItem.setPrice(7);
        }
        return newItem;
    }

    private static void displayInventory(VendingMachine vendingMachine){

        List<ItemShelf> itemShelfList = vendingMachine.getInventory().getInventory();
        itemShelfList.forEach(itemShelf -> {
            System.out.println("CodeNumber: " + itemShelf.getCode() +
                    " Item: " + itemShelf.getItem().getType().name() +
                    " Price: " + itemShelf.getItem().getPrice() +
                    " isAvailable: " + !itemShelf.isSoldOut());
        });
    }

}
