package org.org.headfirst.designpatterns.adapter;

public class Driver {
    public static void main(String [] args) {
        SocketAdapterImpl socketAdapter = new SocketAdapterImpl();
        System.out.println("socketAdapter "+ socketAdapter.get120Volt());
        System.out.println("socketAdapter "+ socketAdapter.get10Volt());
        System.out.println("socketAdapter "+ socketAdapter.get12Volt());
    }
}
