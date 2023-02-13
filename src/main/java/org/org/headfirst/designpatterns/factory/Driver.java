package org.org.headfirst.designpatterns.factory;

public class Driver {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();

        Notification notification1 = notificationFactory.createNotification("EMAIL");
        notification1.notifyUser();
    }
}
