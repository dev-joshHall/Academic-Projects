package org.example.commands;

import org.example.vendorclasses.ApplianceControl;

public class ApplianceCommand implements Command {

    private final ApplianceControl applianceControl;

    public ApplianceCommand() {
        this.applianceControl = new ApplianceControl();
    }

    @Override
    public void on() {
        applianceControl.on();
    }

    @Override
    public void off() {
        applianceControl.off();
    }
}
