## Introduction to Design Pattern

Refference : PatricVideos.com

When you learn a programming languate, you only learn how to read code written by others.

There are many design patter.

Knowing design pattern will distinguish you from junior developpers as senior develper.

It is must to know following design patterns hands on to be a senior enigneer.

1.  Singleton Pattern
2.  Factory Pattern
3.  Template Method Pattern
4.  Adapter Pattern
5.  Facade Pattern
6.  Strategy Pattern
7.  State Pattern
8.  Proxy Pattern
9.  Chain of Responsibility Pattern
10. Bridge Pettern
11. Composite Pattern
12. Decorator Pattern
13. Observer Pattern
14. Builder Pattern
15. Flyweight Pattern
16. Repository Pattern


## Imporantan concetps you should understand in design patterns.

*   Private varibles can be accessed only from within class.

*   Static methods can call only static variables.

*   Static componnets can be accessed from the class name then typing the variable or method name.

*   Defining variables

Suppose A is the supper class and the B is the sub class.

    A obj1 = new A();

    obj1 can access properties of A only

    B obj2 = new B();

    This obj2 is a B object but it is inherited all properties of A too due to B is sub class of A.
    So B can access both A class and B class properties. 

    A obj3 = new B();

    The rule is whatever the left object is obj3 is a right side object. According to above example obj3 is a B() type object. And obj3 has the property of A. Even though this is a B object it cant access B class properties like obj2 does. It can access only A class properties only.

    Smmary : Eventhough obj3 is a B object it has propeties of A only. You can prove it by overriding a method in  A class inside the class B. Then obj3 can access that overridden method from class B. Other wise it cant access methods in class B.

    






