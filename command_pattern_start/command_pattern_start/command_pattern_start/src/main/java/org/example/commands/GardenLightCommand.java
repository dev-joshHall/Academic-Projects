package org.example.commands;

import org.example.vendorclasses.GardenLight;

public class GardenLightCommand implements Command {

    private final GardenLight gardenLight;

    public GardenLightCommand() {
        this.gardenLight = new GardenLight();
    }

    @Override
    public void on() {
        gardenLight.manualOn();
    }

    @Override
    public void off() {
        gardenLight.manualOff();
    }
}
