package hall;

public class MedState extends State {
    @Override
    public void pull() {
        System.out.println("high speed");
        current_state = new HighState();
    }
}