/**
 * This air conditioner is the receiver in command design pattern
 */
public class AirConditioner {
    private boolean isOn;
    private int temperature;

    public void turnOnAc() {
        this.isOn = true;
        System.out.println("Turned on the AC");
    }

    public void turnOffAc() {
        this.isOn = false;
        System.out.println("Turned off the AC");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Set temperature to " + temperature + " degree");
    }
}
