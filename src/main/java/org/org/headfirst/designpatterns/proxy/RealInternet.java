package org.org.headfirst.designpatterns.proxy;

public class RealInternet implements Internet {
    public void connect(String server) {
        System.out.println("You are able to connect to the internet : "+ server);
    }
}
