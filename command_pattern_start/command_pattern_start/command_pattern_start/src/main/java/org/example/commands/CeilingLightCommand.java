package org.example.commands;

import org.example.vendorclasses.CeilingLight;

public class CeilingLightCommand implements Command {

    private final CeilingLight ceilingLight;

    public CeilingLightCommand() {
        this.ceilingLight = new CeilingLight();
    }

    @Override
    public void on() {
        ceilingLight.on();
    }

    @Override
    public void off() {
        ceilingLight.off();
    }
}
