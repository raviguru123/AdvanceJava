package org.org.headfirst.designpatterns.behavioral.state;

public class Vibration implements  MobileAlertState{
    public void alert(AlertContext alertContext) {
        System.out.println("<======= Mobile Vibrate =========>");
    }

}
