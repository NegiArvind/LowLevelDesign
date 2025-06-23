public class Dispute {
    private final String id;
    private final DisputeType disputeType;
    private final String userId;

    Dispute(String id, DisputeType disputeType, String userId) {
        this.id = id;
        this.disputeType = disputeType;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public DisputeType getDisputeType() {
        return disputeType;
    }

    public String getUserId() {
        return userId;
    }

}
