package models;

import strategy.AllInOneCapability;

public class AllInOneManufacturer extends BaseManufacturer{

    public AllInOneManufacturer(String name) {
        super(name, new AllInOneCapability());
    }
}
