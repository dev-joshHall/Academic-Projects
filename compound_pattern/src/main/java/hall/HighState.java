package hall;

public class HighState extends State {
    @Override
    public String name() {
        return "high";
    }

    @Override
    public void pull() {
        current_state = new MedState();
        System.out.println("Current fan speed is " + current_state.name());
    }
}