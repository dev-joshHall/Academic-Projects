package hall;

public class OffState extends State {
    @Override
    public String name() {
        return "off";
    }

    @Override
    public void pull() {
        current_state = new HighState();
        System.out.println("Current fan speed is " + current_state.name());
    }
}
