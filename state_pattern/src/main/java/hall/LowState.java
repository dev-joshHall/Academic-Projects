package hall;

public class LowState extends State {
    @Override
    public void pull() {
        System.out.println("medium speed");
        current_state = new MedState();
    }
}
