import java.util.Set;

public class DemoRunner {
    public static void main(String[] args) {
        AgentRegistry agentRegistry = new AgentRegistry();
        agentRegistry.register(new Agent("Arvind", Set.of(DisputeType.GOLD, DisputeType.PAYMENT)));
        agentRegistry.register(new Agent("Anshul", Set.of(DisputeType.MUTUAL_FUND)));
        agentRegistry.register(new Agent("Gaurav", Set.of(DisputeType.GOLD)));

        DisputeManager manager = new DisputeManager(agentRegistry, new LeastBusyMatchingExpertStrategy());

        manager.raiseDispute(new Dispute("D1", DisputeType.GOLD, "user1"));
        manager.raiseDispute(new Dispute("D2", DisputeType.MUTUAL_FUND, "user2"));
        manager.raiseDispute(new Dispute("D3", DisputeType.GOLD, "user3"));
        manager.raiseDispute(new Dispute("D4", DisputeType.PAYMENT, "user4"));
    }
}
