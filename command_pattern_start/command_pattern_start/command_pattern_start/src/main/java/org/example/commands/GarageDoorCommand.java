package org.example.commands;

import org.example.vendorclasses.garagedoor.GarageDoor;

public class GarageDoorCommand implements Command {

    private final GarageDoor garageDoor;

    private String lastState = "";

    public GarageDoorCommand() {
        this.garageDoor = new GarageDoor();
    }

    @Override
    public void on() {
        if ("open".equals(lastState)) {
            lastState = "stopped";
            garageDoor.stop();
        } else {
            lastState = "open";
            garageDoor.up();
        }
    }

    @Override
    public void off() {
        if ("closed".equals(lastState)) {
            lastState = "stopped";
            garageDoor.stop();
        } else {
            lastState = "closed";
            garageDoor.down();
        }
    }
}
