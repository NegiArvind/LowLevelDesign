import java.util.ArrayList;
import java.util.List;

public class AgentRegistry {
    private final List<Agent> agents = new ArrayList<>();

    public void register(Agent agent) {
        agents.add(agent);
    }

    public List<Agent> getAgents() {
        return agents;
    }
}
