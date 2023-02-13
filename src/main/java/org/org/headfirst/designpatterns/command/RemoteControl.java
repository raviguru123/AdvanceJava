package org.org.headfirst.designpatterns.command;

import lombok.Setter;

@Setter

public class RemoteControl {
    Command command;

    public RemoteControl() {

    }

    public void pressButton() {
        this.command.execute();
    }
}
