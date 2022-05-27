package org.example.commands;
import org.example.vendorclasses.Tv;

public class TvCommand implements Command {

    private final Tv tv;

    public TvCommand() {
        this.tv = new Tv();
    }

    @Override
    public void on() {
        tv.on();
        tv.setVolume(7);
    }

    @Override
    public void off() {
        tv.off();
    }
}
