package models;

import strategy.ScreenLessCapability;

public class ScreenLessManufacturer extends BaseManufacturer {

    public ScreenLessManufacturer(String name) {
        super(name, new ScreenLessCapability());
    }
}
