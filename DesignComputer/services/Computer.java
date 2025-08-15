package services;

import enums.ComputerType;
import models.*;

import java.time.Instant;
import java.util.UUID;

public class Computer {

    private final ComputerType computerType;
    private final Cpu cpu;
    private final Gpu gpu;
    private final Screen screen;
    private final Ram ram;
    private final Psu psu;
    private final UUID buildId = UUID.randomUUID();
    private final Instant builtAt = Instant.now();

    private Computer(Builder builder) {
        this.computerType = builder.computerType;
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.screen = builder.screen;
        this.ram = builder.ram;
        this.psu = builder.psu;
    }

    public UUID getBuildId() {
        return buildId;
    }

    public ComputerType getComputerType() {
        return computerType;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public Screen getScreen() {
        return screen;
    }

    public Ram getRam() {
        return ram;
    }

    public Psu getPsu() {
        return psu;
    }

    public Instant getBuiltAt() {
        return builtAt;
    }

    public String toString() {
        return "Computer{" +
                "type=" + computerType +
                ", cpu=" + (cpu != null ? cpu.getComponentId() : "-") +
                ", ram=" + (ram != null ? ram.getComponentId() : "-") +
                ", psu=" + (psu != null ? psu.getComponentId() : "-") +
                ", gpu=" + (gpu != null ? gpu.getComponentId() : "-") +
                ", screen=" + (screen != null ? screen.getComponentId() : "-") +
                ", buildId=" + buildId +
                '}';
    }

    public static class Builder {
        private ComputerType computerType;
        private Cpu cpu;
        private Gpu gpu;
        private Screen screen;
        private Ram ram;
        private Psu psu;

        public Builder(ComputerType computerType) {
            this.computerType = computerType;
        }

        public Builder addCpu(Cpu c) {
            this.cpu = c;
            return this;
        }

        public Builder addGpu(Gpu g) {
            this.gpu = g;
            return this;
        }

        public Builder addScreen(Screen s) {
            this.screen = s;
            return this;
        }

        public Builder addRam(Ram r) {
            this.ram = r;
            return this;
        }

        public Builder addPsu(Psu p) {
            this.psu = p;
            return this;
        }

        public Computer build() { return new Computer(this); }

    }
}
