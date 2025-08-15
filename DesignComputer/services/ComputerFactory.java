package services;

import enums.ComponentType;
import enums.ComputerType;
import models.*;

import java.util.Set;

public class ComputerFactory {

    private final PartsCatalog partsCatalog;
    public ComputerFactory(PartsCatalog partsCatalog) {
        this.partsCatalog = partsCatalog;
    }

    public Computer assemble(ComputerType computerType) {
        Computer.Builder builder = new Computer.Builder(computerType);
        switch (computerType) {
            case SERVER ->
                builder.addCpu(new Cpu(partsCatalog.getComponentId(ComponentType.CPU)))
                        .addRam(new Ram(partsCatalog.getComponentId(ComponentType.RAM)))
                        .addPsu(new Psu(partsCatalog.getComponentId(ComponentType.PSU)));
            case LAPTOP ->
                builder.addCpu(new Cpu(partsCatalog.getComponentId(ComponentType.CPU)))
                        .addRam(new Ram(partsCatalog.getComponentId(ComponentType.RAM)))
                        .addPsu(new Psu(partsCatalog.getComponentId(ComponentType.PSU)))
                        .addGpu(new Gpu(partsCatalog.getComponentId(ComponentType.GPU)))
                        .addScreen(new Screen(partsCatalog.getComponentId(ComponentType.SCREEN)));
            case DESKTOP ->
                builder.addCpu(new Cpu(partsCatalog.getComponentId(ComponentType.CPU)))
                        .addRam(new Ram(partsCatalog.getComponentId(ComponentType.RAM)))
                        .addPsu(new Psu(partsCatalog.getComponentId(ComponentType.PSU)))
                        .addGpu(new Gpu(partsCatalog.getComponentId(ComponentType.GPU)));
            case TABLET ->
                builder.addCpu(new Cpu(partsCatalog.getComponentId(ComponentType.CPU)))
                        .addRam(new Ram(partsCatalog.getComponentId(ComponentType.RAM)))
                        .addScreen(new Screen(partsCatalog.getComponentId(ComponentType.SCREEN)));
        }
        return builder.build();
    }

    public static Set<ComponentType> requiredComponents(ComputerType type) {
        return switch (type) {
            case SERVER -> Set.of(ComponentType.CPU, ComponentType.RAM, ComponentType.PSU);
            case DESKTOP -> Set.of(ComponentType.CPU, ComponentType.RAM, ComponentType.PSU, ComponentType.GPU);
            case LAPTOP ->
                    Set.of(ComponentType.CPU, ComponentType.RAM, ComponentType.PSU, ComponentType.GPU, ComponentType.SCREEN);
            case TABLET -> Set.of(ComponentType.CPU, ComponentType.RAM, ComponentType.SCREEN);
        };
    }
}
