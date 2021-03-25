package com.pigmiu.design.observer;

/**
 * Created by yli on 2017/5/2.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

