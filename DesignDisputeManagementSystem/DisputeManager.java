public class DisputeManager {

    private final AgentRegistry agentRegistry;
    private AssignmentStrategy assignmentStrategy;

    public DisputeManager(AgentRegistry agentRegistry, AssignmentStrategy assignmentStrategy) {
        this.agentRegistry = agentRegistry;
        this.assignmentStrategy = assignmentStrategy;
    }

    public void raiseDispute(Dispute dispute) {
        Agent agent = assignmentStrategy.assign(dispute, agentRegistry.getAgents());
        agent.assign(dispute);
        System.out.println("Assigned Dispute " + dispute.getId() + " to " + agent.getName());
    }

    public void setAssignmentStrategy(AssignmentStrategy assignmentStrategy) {
        this.assignmentStrategy = assignmentStrategy;
    }
}
