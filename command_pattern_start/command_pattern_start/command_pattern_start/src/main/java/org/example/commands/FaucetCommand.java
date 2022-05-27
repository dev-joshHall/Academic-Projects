package org.example.commands;

import org.example.vendorclasses.FaucetControl;

public class FaucetCommand implements Command {

    private final FaucetControl faucetControl;

    public FaucetCommand() {
        this.faucetControl = new FaucetControl();
    }

    @Override
    public void on() {
        faucetControl.openValve();
    }

    @Override
    public void off() {
        faucetControl.closeValve();
    }
}
