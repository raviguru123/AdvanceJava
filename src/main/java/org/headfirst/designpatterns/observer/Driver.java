package org.headfirst.designpatterns.observer;

public class Driver {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setChanged(10, 10, 10);
        weatherData.setChanged(10, 10, 20);
        weatherData.setChanged(15, 20, 30);
    }
}
