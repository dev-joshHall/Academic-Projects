package org.example.commands;

import org.example.vendorclasses.stereo.Stereo;

public class StereoCommand implements Command {

    private final Stereo stereo;

    private String currentMode = "";

    public StereoCommand() {
        this.stereo = new Stereo();
    }

    @Override
    public void on() {
        switch (currentMode) {
            case "" -> {
                currentMode = "radio";
                stereo.on();
                stereo.setRadio();
            }
            case "radio" -> {
                currentMode = "dvd";
                stereo.setDvd();
            }
            case "dvd" -> {
                currentMode = "cd";
                stereo.setCd();
            }
            case "cd" -> {
                currentMode = "radio";
                stereo.setRadio();
            }
        }
    }

    @Override
    public void off() {
        stereo.off();
        switch (currentMode) {
            case "radio" -> currentMode = "cd";
            case "dvd" -> currentMode = "radio";
            case "cd" -> currentMode = "dvd";
        }
    }
}
