package org.org.headfirst.designpatterns.factory;

public class EMAILNotification implements Notification {
    public void notifyUser() {
        System.out.println("Send Notification Via Email");
    }
}
