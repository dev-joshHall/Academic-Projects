package org.example.commands;

import org.example.vendorclasses.OutdoorLight;

public class OutdoorLightCommand implements Command {

    private final OutdoorLight outdoorLight;

    public OutdoorLightCommand() {
        this.outdoorLight = new OutdoorLight();
    }

    @Override
    public void on() {
        outdoorLight.on();
    }

    @Override
    public void off() {
        outdoorLight.off();
    }
}
