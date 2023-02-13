package org.headfirst.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer {
    Observable observable;
    private float humidity;
    private float temperature;
    private float pressure;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    public void update(Observable observable, Object org) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.humidity = weatherData.getHumidity();
            this.temperature = weatherData.getTemperature();
            this.pressure = weatherData.getPressure();
            this.display();
        }

    }

    public void display() {
        System.out.println("Measurement Changed => humidity : " +
                this.humidity + " temperature :" + this.temperature + " pressure :" + this.pressure);
    }
}
