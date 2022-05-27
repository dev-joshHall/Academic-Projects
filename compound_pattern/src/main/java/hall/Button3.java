package hall;

public class Button3 extends Button {
    public Button3(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void on() {
        this.ceilingFan.low();
    }

    @Override
    public void off() {
        this.ceilingFan.off();
    }
}
