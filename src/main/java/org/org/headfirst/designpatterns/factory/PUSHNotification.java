package org.org.headfirst.designpatterns.factory;

public class PUSHNotification implements Notification {
    public void notifyUser() {
        System.out.println("Send Notification Via Push");
    }
}
