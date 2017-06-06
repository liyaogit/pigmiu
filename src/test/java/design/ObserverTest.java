package design;

import com.design.observer.CurrentConditionsDisplay;
import com.design.observer.WeatherData;
import org.junit.Test;

/**
 * Created by yli on 2017/5/3.
 */
public class ObserverTest {
    @Test
    public void testCurrentConditionsDisplay(){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,25.5f);
    }
}
