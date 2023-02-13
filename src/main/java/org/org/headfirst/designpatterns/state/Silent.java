package org.org.headfirst.designpatterns.state;

public class Silent implements  MobileAlertState{
    public void alert(AlertContext alertContext) {
        System.out.println("<======= Mobile Silent =========>");
    }

}
