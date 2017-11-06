package com.design.observer;

import java.util.ArrayList;

/**
 * 可观察对象
 * Created by yli on 2017/5/2.
 */
public class WeatherData implements Subject {
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        this.observers = new ArrayList();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
//      boolean remove = observers.remove(o);
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for(Object o : observers){
            Observer observer = (Observer) o;
            observer.update(temperature,humidity,pressure);
        }
    }

    private void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
