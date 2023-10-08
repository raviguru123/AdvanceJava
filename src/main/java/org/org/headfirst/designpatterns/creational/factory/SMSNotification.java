package org.org.headfirst.designpatterns.creational.factory;

public class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Send Notification Via SMSNotification");
    }
}
