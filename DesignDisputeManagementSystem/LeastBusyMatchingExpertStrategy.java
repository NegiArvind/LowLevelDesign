import java.util.Comparator;
import java.util.List;

public class LeastBusyMatchingExpertStrategy implements AssignmentStrategy {
    @Override
    public Agent assign(Dispute dispute, List<Agent> agents) {
        return agents.stream().filter(agent -> agent.canHandle(dispute.getDisputeType()))
                .min(Comparator.comparingInt(Agent::getWorkLoad))
                .orElseThrow(() -> new RuntimeException("No available agent for type " + dispute.getDisputeType()));
    }
}
