package services;

import enums.ComputerType;
import models.Manufacturer;

import java.util.List;

public class WorkAllocator {

    private List<Manufacturer> manufacturers;
    private int cursor = 0;

    public WorkAllocator(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Manufacturer nextCapable(ComputerType computerType) {
        if(manufacturers.isEmpty()) {
            return null;
        }
        int n = manufacturers.size();
        for(int i=0; i< n; i++) {
            int idx = (cursor + i) % n;
            Manufacturer manufacturer = manufacturers.get(idx);
            if(manufacturer.getCapabilityStrategy().canBuild(computerType)) {
                cursor = (idx + 1) % n;
                return manufacturer;
            }
        }
        return null;
    }
}
