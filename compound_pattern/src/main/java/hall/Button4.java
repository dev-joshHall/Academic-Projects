package hall;

public class Button4 extends Button {
    public Button4(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void on() {
        this.ceilingFan.fanSpeed.pull();
        this.ceilingFan.fanSpeed = this.ceilingFan.fanSpeed.current_state;
    }

    @Override
    public void off() {
        this.ceilingFan.off();
    }
}
