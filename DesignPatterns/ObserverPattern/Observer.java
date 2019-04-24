/**
 The Obserer interface is implemented by all observers, so they all have to implement
 the update() method. 
 */
public interface Observer{
    /**
     * 
     There are the state values the Observers get from 
     the subject when a weather measurement change
     */
    public void update(float temp, float humidity, float pressure);


}