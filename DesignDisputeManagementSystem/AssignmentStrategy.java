import java.util.List;

public interface AssignmentStrategy {
    Agent assign(Dispute dispute, List<Agent> agents);
}
