
# Abstraction

## Abstract class in Java

A class which is declared with the abstract keyword is known as an abstract class in Java. It can have abstract and non-abstract methods (method with the body).

Before learning the Java abstract class, let's understand the abstraction in Java first.


### Abstraction in Java

Abstraction is a process of hiding the implementation details and showing only functionality to the user.

Another way, it shows only essential things to the user and hides the internal details, for example, sending SMS where you type the text and send the message. You don't know the internal processing about the message delivery.

Abstraction lets you focus on what the object does instead of how it does it.
Ways to achieve Abstraction

There are two ways to achieve abstraction in java

    Abstract class (0 to 100%)
    Interface (100%)

### Abstract class in Java

A class which is declared as abstract is known as an abstract class. It can have abstract and non-abstract methods. It needs to be extended and its method implemented. It cannot be instantiated.
Points to Remember

    An abstract class must be declared with an abstract keyword.
    It can have abstract and non-abstract methods.
    It cannot be instantiated.
    It can have constructors and static methods also.
    It can have final methods which will force the subclass not to change the body of the method.

![Abstraction](abstraction.png?raw=true "Abstraction")


### Example of abstract class

        abstract class A{}  

### Abstract Method in java

A method which is declared as abstract and does not have implementation is known as an abstract method. 

        abstract void printStatus();//no method body and abstract  

### Esample of Abstract class that have abstract method

In this example, Bike is an abstract class that contains only one abstract method run. Its implementation is provided by the Honda class.

```
    abstract class Bike{  
      abstract void run();  
    }  
    class Honda4 extends Bike{  
    void run(){System.out.println("running safely");}  
    public static void main(String args[]){  
     Bike obj = new Honda4();  
     obj.run(); 

     // if you try to initiate object with follwoing way
     // Bike obj = new Bike();
     // compile error will be
     // error: Bike is abstract; cannot be instantiated Bike obj = new Bike();
    }  
    }  

```

output : running safely

### understanding the real scenario of Abstract class

In this example, Shape is the abstract class, and its implementation is provided by the Rectangle and Circle classes.
Mostly, we don't know about the implementation class (which is hidden to the end user), and an object of the implementation class is provided by the factory method.

A factory method is a method that returns the instance of the class. We will learn about the factory method later.

In this example, if you create the instance of Rectangle class, draw() method of Rectangle class will be invoked.

```
abstract class Shape{  
abstract void draw();  
}  
//In real scenario, implementation is provided by others i.e. unknown by end user  
class Rectangle extends Shape{  
void draw(){System.out.println("drawing rectangle");}  
}  
class Circle1 extends Shape{  
void draw(){System.out.println("drawing circle");}  
}  
//In real scenario, method is called by programmer or user  
class TestAbstraction1{  
public static void main(String args[]){  
Shape s=new Circle1();//In a real scenario, object is provided through method, e.g., getShape() method  
s.draw();  
}  
} 

```

Output : drawing circle


### Abstract class having constructor, data member and methods 

An abstract class can have a data member, abstract method, method body (non-abstract method), constructor, and even main() method.

