import java.util.Stack;

/**
 * This is invoker
 */
public class MyRemoteControl {

    private ICommand command;
    private Stack<ICommand> acCommandHistory;

    MyRemoteControl() {
        acCommandHistory = new Stack<>();
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        acCommandHistory.add(command);
    }

    public void undo() {
        if(!acCommandHistory.isEmpty()) {
            acCommandHistory.pop().undo();
        }
    }

}
