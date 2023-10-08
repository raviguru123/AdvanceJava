package org.org.headfirst.designpatterns.behavioral.command;

public class Driver {
    public static void main(String [] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.pressButton();
        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.pressButton();
    }
}
