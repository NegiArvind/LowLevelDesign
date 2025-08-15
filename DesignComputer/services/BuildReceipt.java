package services;

import java.time.Instant;
import java.util.UUID;

public class BuildReceipt {
    private final UUID manufacturerId;
    private final long orderId;
    private final UUID buildId;
    private final Instant completedAt = Instant.now();
    public BuildReceipt(UUID manufacturerId, long orderId, UUID buildId) {
        this.manufacturerId = manufacturerId;
        this.orderId = orderId;
        this.buildId = buildId;
    }

    public String toString() {
        return "BuildReceipt{" + "manufacturerId=" + manufacturerId
                + ", orderId=" + orderId + ", buildId="
                + buildId + ", completedAt=" + completedAt + '}'; }

}
