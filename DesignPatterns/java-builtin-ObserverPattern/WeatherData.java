
// make sure we are importing the right Observer/Observable classes
import java.util.Observable;
import java.util.Observer;

// We are now subclassing Observable
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    /**
     Our constructor no longer needs to create a data structure to hold Observer
     */
    public WeatherData(){ }

    public void measurementsChanged(){
        setChanged();
        /**
         We now first call setChanged() to indicate
         the state has changed before calling nogigyObservers().
         */
        notifyObservers();
        /**
         Notice we aren't sending a data object with the notifyObservers() call.
         That means we're using the PULL model
         */

    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    /**
     These methods aren't new, but becouse we are going to use "pull"
     we thought we'd remind you they are here.
     The Observers will use them to get at the WeatherData object state
     */
    public float getTemperature(){
        return temperature;
    }


    public float getHumidity(){
        return humidity;
    }

    public float getPressure(){
        return pressure;
    }


}