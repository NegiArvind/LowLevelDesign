package models;

import enums.ComputerType;

import java.time.Instant;

public class Order {
    private final long id;
    private final ComputerType type;
    private final Instant createdAt = Instant.now();

    public Order(long id, ComputerType type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public ComputerType getType() {
        return type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
