import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Agent {
    private final String name;
    private final Set<DisputeType> expertise;
    private final Queue<Dispute> assignedDisputes = new LinkedList<>();

    public Agent(String name, Set<DisputeType> expertise) {
        this.name = name;
        this.expertise = expertise;
    }

    public boolean canHandle(DisputeType disputeType) {
        return expertise.contains(disputeType);
    }

    public int getWorkLoad() {
        return assignedDisputes.size();
    }

    public void assign(Dispute dispute) {
        assignedDisputes.add(dispute);
    }

    public String getName() {
        return name;
    }
}
