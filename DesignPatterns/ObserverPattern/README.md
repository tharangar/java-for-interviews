
## The Observer Pattern

If you want a pattern that keeps your objects in the know when something they might care about happens. The observer pattern is the one of the most heavily used pattern in the JDK.

### Definition

The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.

Further dependent objects and subscribe and unsubscribe too in run time.

There are a few different ways to implement the Observer Pattern but most revolve around a class design that includes Subject and Observer interface.

![Observer Pattern](./observer.png)

## Example :
## The Weather Monitoring applicaiton overview

The three players in the system are the weather station (the physical device that acquires the actual weather data), the WeatherData object (that tracks the data comming from the Weather Station and updates the displayes), and the diplay that shows users the current weather conditions.

