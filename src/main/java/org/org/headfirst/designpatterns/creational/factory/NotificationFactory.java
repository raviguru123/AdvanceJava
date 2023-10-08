package org.org.headfirst.designpatterns.creational.factory;

public class NotificationFactory {
    public Notification createNotification(String name) {
        switch (name) {
            case "PUSH":
                return new PUSHNotification();
            case "EMAIL":
                return new EMAILNotification();
            case "SMS":
                return new SMSNotification();
            default:
                throw new IllegalArgumentException("Invalid argument");
        }
    }
}
