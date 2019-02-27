package com.design.observer;

/**
 * 观察者
 * 状态只关心温度和湿度，用来展示
 * 主题只关心天气数据
 * Created by yli on 2017/5/2.
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement{
    private float temperature;
    private float humidity;
//    private Subject weatherData;

    //注册观察主题
    public CurrentConditionsDisplay(Subject weatherData) {
//        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        diplay();
    }

    public void diplay() {
        System.out.println("目前温度"+temperature+"摄氏度，湿度:"+humidity+"%");
    }
}
