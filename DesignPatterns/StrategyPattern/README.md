
## The Strategy Pattern

The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.

Strategy lets the algorithm vary independently from clients that use it.

strategy.png

### Compiling and using it

```
javac Duck.java

javac FlyNoWay.java

javac FlyWithWings.java

javac FlyNoWay.java

javac QuackBehavior.java

javac Quack.java

javac MuteQuack.java

javac Squeak.java

javac MiniDuckSimulator.java

java MiniDuckSimulator

// Checking the dynamic behaviour of the behavior

javac ModelDuck.java

javac FlyRocketPowered.java 

javac MiniDuckSimulator.java

java MiniDuckSimulator

```