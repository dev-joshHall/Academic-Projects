package hall;

public class Button2 extends Button {
    public Button2(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void on() {
        this.ceilingFan.medium();
    }

    @Override
    public void off() {
        this.ceilingFan.off();
    }
}
