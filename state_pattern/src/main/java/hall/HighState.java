package hall;

public class HighState extends State {
    @Override
    public void pull() {
        System.out.println("turning off...");
        current_state = new OffState();
    }
}