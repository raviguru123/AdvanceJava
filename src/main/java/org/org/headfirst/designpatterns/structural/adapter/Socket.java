package org.org.headfirst.designpatterns.structural.adapter;

import lombok.Getter;

@Getter
public class Socket {
    private final Volt volt;

    public Socket() {
        this.volt = new Volt(120);
    }
}
