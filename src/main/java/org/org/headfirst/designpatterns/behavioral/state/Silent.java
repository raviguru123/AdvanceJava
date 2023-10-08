package org.org.headfirst.designpatterns.behavioral.state;

public class Silent implements  MobileAlertState {
    public void alert(AlertContext alertContext) {
        System.out.println("<======= Mobile Silent =========>");
    }

}
