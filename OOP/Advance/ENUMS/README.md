# ENUMS

## JAVA ENUMS

An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).


## Difference between Enums and Classes

An enum can, just like a class, have attributes and methods. The only difference is that enum constants are public, static and final (unchangeable - cannot be overridden).

An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).
Why And When To Use Enums?

Use enums when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.

To create an enum, use the enum keyword (instead of class or interface), and separate the constants with a comma. Note that they should be in uppercase letters:



```
enum Level {
  LOW,
  MEDIUM,
  HIGH
}


```


Access the Enum from any other program.

```
 Level myVar = Level.MEDIUM; 
```



##  Enums inside classes

```
public class Main {
  enum Level {
    LOW,
    MEDIUM,
    HIGH
  }

  public static void main(String[] args) {
    Level myVar = Level.MEDIUM; 
    System.out.println(myVar);
  }
}


```


## Enum in Switch Statement

```
enum Level {
  LOW,
  MEDIUM,
  HIGH
}

public class Main {
  public static void main(String[] args) {
    Level myVar = Level.MEDIUM;

    switch(myVar) {
      case LOW:
        System.out.println("Low level");
        break;
      case MEDIUM:
         System.out.println("Medium level");
        break;
      case HIGH:
        System.out.println("High level");
        break;
    }
  }
}


```


## Loop through an Enum

```
for (Level myVar : Level.values()) {
  System.out.println(myVar);
}


```