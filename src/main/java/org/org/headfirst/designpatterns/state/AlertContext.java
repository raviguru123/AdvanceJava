package org.org.headfirst.designpatterns.state;

import lombok.Setter;

@Setter
public class AlertContext {
    MobileAlertState mobileAlertState;

    public AlertContext() {
        this.mobileAlertState = new Vibration();
    }

    public void alert() {
        this.mobileAlertState.alert(this);
    }
}
