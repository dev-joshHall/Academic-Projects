package org.example.commands;

import org.example.vendorclasses.Thermostat;

public class ThermostatCommand implements Command {

    private final Thermostat thermostat;

    public ThermostatCommand() {
        this.thermostat = new Thermostat();
    }

    @Override
    public void on() {
        thermostat.setTemperature(thermostat.getTemperature() + 1);
    }

    @Override
    public void off() {
        thermostat.setTemperature(thermostat.getTemperature() - 1);
    }
}
