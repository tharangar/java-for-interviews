// Make sure we are importing the right Observer/Observable
import java.util.Observable;
import java.util.Observer;

// We now are implementing the Observer interface java util
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;
    /**
     Our constructor now takes an Observable and we use this to add the current conditions object as an Observer.
     */
    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    /**
     we've changed the update() method to take both an Observable and the optional data argument.
     
     In update(), we first make sure the obsrvable
     is of type WeatherData and then we use its getter methods to obtain the temperature and humidity measurements.
     After that we call display()
     */
    public void update(Observable obs, Object org){
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display(){
        System.out.println("Current conditions :" + temperature + " F degrees and " + humidity + " % humidty ");
    }

}