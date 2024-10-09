public class TurnOffAcCommand implements ICommand {

    private AirConditioner ac;
    TurnOffAcCommand(AirConditioner ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.turnOffAc();
    }

    @Override
    public void undo() {
        ac.turnOnAc();
    }
}
