package hall;

public class LowState extends State {
    @Override
    public String name() {
        return "low";
    }

    @Override
    public void pull() {
        current_state = new OffState();
        System.out.println("Current fan speed is " + current_state.name());
    }
}
