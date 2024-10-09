public class TurnOnAcCommand implements ICommand {

    AirConditioner ac;

    TurnOnAcCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAc();;
    }

    @Override
    public void undo() {
        ac.turnOffAc();
    }
}
