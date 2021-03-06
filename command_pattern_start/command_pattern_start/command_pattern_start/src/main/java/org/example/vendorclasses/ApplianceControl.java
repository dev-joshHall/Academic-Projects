package org.example.vendorclasses;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class ApplianceControl {
    private boolean powerState = false;

    public void on() {
        powerState = true;
        printPowerState();
    }

    public void off() {
        powerState = false;
        printPowerState();
    }

    public boolean isPoweredOn() {
        return powerState;
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("Appliance is %s\n", stateString);
    }
}
