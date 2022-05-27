package org.example.commands;

import org.example.vendorclasses.securitysystem.SecurityControl;

public class SecurityCommand implements Command {

    private final SecurityControl securityControl;

    public SecurityCommand() {
        this.securityControl = new SecurityControl();
    }

    @Override
    public void on() {
        securityControl.arm();
    }

    @Override
    public void off() {
        securityControl.disarm();
    }
}
