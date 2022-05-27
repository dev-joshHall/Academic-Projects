package org.example;

import org.example.commands.*;
import org.example.remotecontrol.RemoteControl;
import org.example.remotecontrol.RemoteControlSlot;

/**
 * Author: Joshua Hall
 * Project: Command Pattern
 * Description: Implements the Command Pattern
 * */
public class App {

    public static void main( String[] args ) {
        RemoteControl remoteControl = new RemoteControl();

        /*
         * The two code blocks below are provided as a demonstration of how the remote control should be used.
         * Replace this code with your own commands to fill up the entire functionality of the remote
         * with the command classes that you create.
         * TODO: Replace the below blocks with your own tests
         * */
        System.out.println("Assigning the sprinklers to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Turbo Sprinklers", new SprinklerCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Light to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Hallway Light", new LightCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Appliance Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Central Appliance Command", new ApplianceCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Ceiling Light to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Living-room Ceiling Light Command", new CeilingLightCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Faucet Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Central Faucet Command", new FaucetCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Garden Light Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Main Garden Light Command", new GardenLightCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Hot Tub Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Backyard Hot Tub Command", new HotTubCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Outdoor Light Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Backyard Outdoor Light Command", new OutdoorLightCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Thermostat Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Home Thermostat Command", new ThermostatCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a TV Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Family Room TV Command", new TvCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Ceiling Fan Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Family Room Ceiling Fan Command", new CeilingFanCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Garage Door Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Main Garage Door Command", new GarageDoorCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Security Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Main Security Command", new SecurityCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Stereo Control to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Bedroom Stereo Command", new StereoCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

    }

    public static void printSeparator() {
        System.out.println("--------------------------------------");
    }
}
