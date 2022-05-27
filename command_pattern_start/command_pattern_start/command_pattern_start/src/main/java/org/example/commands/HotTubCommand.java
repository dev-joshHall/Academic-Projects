package org.example.commands;

import org.example.vendorclasses.HotTub;

public class HotTubCommand implements Command {

    private final HotTub hotTub;

    public HotTubCommand() {
        this.hotTub = new HotTub();
    }

    @Override
    public void on() {
        hotTub.jetsOn();
        hotTub.circulate();
    }

    @Override
    public void off() {
        hotTub.jetsOff();
        hotTub.circulate();
    }
}
