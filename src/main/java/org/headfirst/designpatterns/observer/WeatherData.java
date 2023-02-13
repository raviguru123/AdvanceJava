package org.headfirst.designpatterns.observer;

import lombok.Getter;
import lombok.NonNull;

import java.util.Observable;

@Getter
public class WeatherData extends Observable {
    private float humidity;
    private float temperature;
    private float pressure;

    public WeatherData() {

    }

    public void measurementChanged() {
        setChanged();
        notifyObservers();
    }

    public void setChanged(@NonNull final float humidity, @NonNull final float temperature, @NonNull final float pressure) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;
        this.measurementChanged();
    }
}
