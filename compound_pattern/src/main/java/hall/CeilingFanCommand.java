package hall;

public class CeilingFanCommand {
    private final CeilingFan ceilingFan;
    public final Button button1;
    public final Button button2;
    public final Button button3;
    public final Button button4;

    public CeilingFanCommand() {
        this.ceilingFan = new CeilingFan();
        button1 = new Button1(ceilingFan);
        button2 = new Button2(ceilingFan);
        button3 = new Button3(ceilingFan);
        button4 = new Button4(ceilingFan);
    }


}
