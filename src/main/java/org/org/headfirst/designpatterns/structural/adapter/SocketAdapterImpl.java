package org.org.headfirst.designpatterns.structural.adapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter {
    public Volt get120Volt() {
        Volt v = getVolt();
        return v;
    }

    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVoltage(v, 10);
    }

    public Volt get10Volt() {
        Volt v = getVolt();
        return convertVoltage(v, 12);
    }

    private Volt convertVoltage(Volt volt, int i) {
        return new Volt(volt.getVolt() / i);
    }
}
