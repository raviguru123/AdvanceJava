package org.org.headfirst.designpatterns.adapter;

public interface SocketAdapter {
    public Volt get120Volt();
    public Volt get12Volt();

    public Volt get10Volt();
}
