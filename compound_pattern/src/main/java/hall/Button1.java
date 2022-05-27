package hall;

public class Button1 extends Button {
    public Button1(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void on() {
        this.ceilingFan.high();
    }

    @Override
    public void off() {
        this.ceilingFan.off();
    }
}
