package models;

import strategy.GenericCapability;

public class GenericManufacturer extends BaseManufacturer {

    public GenericManufacturer(String name) {
        super(name, new GenericCapability());
    }
}
