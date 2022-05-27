package org.example.commands;

import org.example.vendorclasses.fan.CeilingFan;

public class CeilingFanCommand implements Command {

    private final CeilingFan ceilingFan;

    private String lastState = "";

    public CeilingFanCommand() {
        this.ceilingFan = new CeilingFan();
    }

    @Override
    public void on() {
        switch (lastState) {
            case "", "high" -> {
                ceilingFan.low();
                lastState = "low";
            }
            case "low" -> {
                ceilingFan.medium();
                lastState = "med";
            }
            case "med" -> {
                ceilingFan.high();
                lastState = "high";
            }
        }
    }

    @Override
    public void off() {
        ceilingFan.off();
        switch (lastState) {
            case "low" -> lastState = "high";
            case "med" -> lastState = "low";
            case "high" -> lastState = "med";
        }
    }
}
