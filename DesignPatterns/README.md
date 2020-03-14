
# Design Patterns

Design patterns are not just using Object Oritented concepts. OO concpets are underlined the design patterns . Design patterns are non-obvious, ways of constructing object-oriented systems have been collected.

Design Patterns give you a shared vocabulary with other developpers.
Once you've got the vocabulary you can more easily ocmmiunicate with other
developpers and inspire those who don't know patterns to start learning them.
It also elevates your thinking about architectures by letting you think at the pattern level, 
not the nitty gritty object level.

### Advantages of using desing patterns

1. Shared pattern vocabularies are powerful.

2. Patterns allow you to say more with less.

3. Talking at the pattern level allows you to stay "in the design" longer.
4. Shared vocabularies encourage more junior developers to get up to speed.

## How do i use Design Patterns

Design Pattersn first should be loaded in to your brain.
Once you've loaded them to your brain with a good working knowledge of patterns, you can then start to apply them to your new design and rework your old code.

Fraemworks and libraries are not design patterns; they provide specific implemenations that we link into our code. However, libraries and frameworks make use of design patterns in their implementaions.


## Tools for your Design Tool box

1. OO Basics

    Abstraction

    Encapsulation

    Polymorphism

    Inheritance

2. OO Principles

    Encapsulate what varies.

    Favour composition over inheritance.

    Program to interface, not implemenation

    Strive for loosely coupled designs between objects that interact.

    Classes should be open for extension but closed for modification.

3.  OO Patterns

    Strategy - Design a family of algorithms

    Observer - Define a one to many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically

    
    
## Bullet points

1. Good OO desingers are resusable, extensible and maintainable.

2. Patterns show how to build systms with good OO design qualities.

3. Pattern don't give you code, they give you general solutions to design problems. You apply them to your specific applicaiton.

4. Most patterns allow some part of a systme to vary independently of all other parts.

5. Patterns provide a shared language that can maximize the value of your communication with other developers.

Pattern is a solution to a problem in a context.
Design patterns are general solutions to common problems. A pattern is a guildeline for flexible and resilient code desing.

### Inheritance

Inheritance is a core principle of OOP.
CAT IS-A feline.

So Cat is a subclass of Feline class. Tiger is another subclass of Feline class.

Example

:There is a Duck class which has following behaviors.
1.  quack()
2.  swim()
3.  display()

MallarDuck, RedheadDuck are subclasses of this class and all methods inherited from parent class. But display is defferent from each other, so display() method is overridden in all subclasses.
Suppose we are going to add RubberDuck subclass. This duck quack() mehtod also to be overridden due to it is completly defferent.

![Inheritance ](duck.png?raw=true "inheritance")

Issue in above method is run time changes are not difficutl.

So Interfaces were introduced. Following are the attributes of interfaces .

Allow different classes to share similarities.

Not all classes need to have the same behaviour.

Let us try moving duck behaviours into interfaces.


![Interfaces ](duck-interface.png?raw=true "Interfaces")


So we can see we haven't being able to achive full code reusability using both inheritance and interfaces.

So Lets discuss some design principles and how to achive above senario.

### Design Principle 1

Identify the aspects of your code that vary and seperate them from what stays the same.

As a example quick() and fly() are two behaviors which varies .

The solution is encapsulate what varies. If some aspect of code is changing , that is sign you should pull it out and seperate it.

This principle is ufndamental to almost every design pattern.

All patterns let some part of the code vary independently of the other parts.

![Design Principle 1 ](prin1.png?raw=true "Principle 1")

### Design Principle 2

Program to an interface, not an implementation.


Interface is a class that implements a specific behaviour.

#### HAS-A Relationship

Rather than relaying on an implementation of behaviour in our ducks we are relaying on an interface.
FlyBehaviour and QuackBehaviour are now interfaces. 

In this way we can desides behaviours in run time for each duck.

This way we are no longer locked into specidic implementaiton and ducks do not need to know details of how they implement the behaviours.

This is also called HAS-A relationship.

Each duck has a FlyBehaviour and QuackBehavior.


![Design Principle 2 ](prin2.png?raw=true "Principle 2")


### Design Principle 3

Favor compositon over inheritance.

We can introduce two interfaces asn QuackBehaviour and FlyBehavior and create concreate sub classes to do the bahaviours in deffernt ways.


![Design Principle 3 ](prin3.png?raw=true "Principle 3")




### Design Principle 4

Strive for loosely coupled design between objects that interact.



### Design Principle 5

Classes should be open for extention but closed for modification.

