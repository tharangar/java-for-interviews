/**
 * 
 This display implements Observer so it can get changes from the weatherDeata object.
 It also implements DisplayElement, becouse our API is going to rquire all dipslay elements to implement this interface
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    /**
     *
     The constructor is passed the weatherData object (The subject) and
     we use it to register the display as an observer
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    /**
     Why did we store a reffernece to the Subject ?. It doesn't look like you use it again after the constructor?
     True but in the future we may want to un-register ourselves as an observer and it would be handy to already have a reference to the subject.
     */

     

    /**
     When update() is called, we save the temp and humidity and call display()
     */
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    /**
     The display() method just prints out the most recent temp and humidity.
     */
    public void display(){
        System.out.println("Curent coditions : "+ temperature +" F degree and  "+humidity+" % humidity ");
    }

}