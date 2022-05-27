package hall;


public class CeilingFan {
    private boolean powerState = false;
    public State fanSpeed = new LowState();

    public void off() {
        powerState = false;
        fanSpeed = new OffState();
        printPowerState();
    }

    public State getSpeed() {
        printFanSpeed();
        return fanSpeed;
    }

    public void low() {
        powerState = true;
        fanSpeed = new LowState();
        printFanSpeed();
    }

    public void medium() {
        powerState = true;
        fanSpeed = new MedState();
        printFanSpeed();
    }

    public void high() {
        powerState = true;
        fanSpeed = new HighState();
        printFanSpeed();
    }

    private void printFanSpeed() {
        System.out.println("Current fan speed is " + fanSpeed.name());
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("Ceiling Fan is %s\n", stateString);
    }

    public boolean isOn() {
        return powerState;
    }
}
