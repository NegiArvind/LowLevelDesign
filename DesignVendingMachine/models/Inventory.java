package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    List<ItemShelf> inventory;
    private int itemCount;

    Inventory(int itemCount) {
        inventory = new ArrayList<>(itemCount);
        this.itemCount = itemCount;
        initializeEmptyInventory();
    }

    public List<ItemShelf> getInventory() {
        return inventory;
    }

    public void setInventory(List<ItemShelf> inventory) {
        this.inventory = inventory;
    }

    private void initializeEmptyInventory() {
        int startCode = 101;
        for(int i=0; i< itemCount ; i++) {
            ItemShelf itemShelf = new ItemShelf(null, startCode+i, true);
            inventory.add(itemShelf);
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        ItemShelf existingItem = inventory.stream().filter(itemShelf -> itemShelf.code == codeNumber).findAny().orElse(null);
        if(Objects.nonNull(existingItem)) {
            throw new Exception("Item with this code is already present, you can not add item here");
        }
        inventory.add(new ItemShelf(item, codeNumber, false));
    }

    public Item getItem(int codeNumber) {
        ItemShelf existingItemShelf = inventory.stream().filter(itemShelf -> itemShelf.code == codeNumber).findFirst().orElse(null);
        if(Objects.nonNull(existingItemShelf)){
            return existingItemShelf.item;
        }
        return null;
    }

    public void updateSoldOutItem(int codeNumber) {
        inventory.stream()
                .filter(itemShelf -> itemShelf.getCode() == codeNumber)
                .findFirst()
                .ifPresent(itemShelf -> itemShelf.setSoldOut(true));
    }


}
