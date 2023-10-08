package org.org.headfirst.designpatterns.behavioral.state;

public class Driver {
    public static void main(String[] args) {
        AlertContext alertContext = new AlertContext();
        alertContext.alert();

        alertContext.setMobileAlertState(new Silent());
        alertContext.alert();
    }
}
