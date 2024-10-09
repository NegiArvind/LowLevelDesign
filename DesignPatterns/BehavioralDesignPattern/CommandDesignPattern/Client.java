public class Client {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        MyRemoteControl myRemoteControl = new MyRemoteControl();

        myRemoteControl.setCommand(new TurnOnAcCommand(airConditioner));
        myRemoteControl.pressButton();
        myRemoteControl.undo();

        myRemoteControl.setCommand(new TurnOffAcCommand(airConditioner));
        myRemoteControl.pressButton();
        myRemoteControl.undo();


        myRemoteControl.setCommand(new UpdateTemperatureCommand(airConditioner, 20));
        myRemoteControl.pressButton();

    }
}
