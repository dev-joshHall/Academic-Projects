package hall;

public class OffState extends State {
    @Override
    public void pull() {
        System.out.println("low speed");
        current_state = new LowState();
    }
}
