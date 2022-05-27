package hall;

public class MedState extends State {
    @Override
    public String name() {
        return "medium";
    }

    @Override
    public void pull() {
        current_state = new LowState();
        System.out.println("Current fan speed is " + current_state.name());
    }
}