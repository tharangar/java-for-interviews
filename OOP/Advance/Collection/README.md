## Collection in java

The Collection in Java is a framework that provides an architecture to store and manipulate the group of objects.

Java Collections can achieve all the operations that you perform on a data such as searching, sorting, insertion, manipulation, and deletion.

Java Collection means a single unit of objects. Java Collection framework provides many interfaces (Set, List, Queue, Deque) and classes (ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet).

### What is Collection in Java

A Collection represents a single unit of objects, i.e., a group.
What is a framework in Java

    It provides readymade architecture.
    It represents a set of classes and interfaces.
    It is optional.

### What is Collection framework

The Collection framework represents a unified architecture for storing and manipulating a group of objects. It has:

    Interfaces and its implementations, i.e., classes
    Algorithm

### Do you know



    What are the two ways to iterate the elements of a collection?

    What is the difference between ArrayList and LinkedList classes in collection framework?

    What is the difference between ArrayList and Vector classes in collection framework?

    What is the difference between HashSet and HashMap classes in collection framework?

    What is the difference between HashMap and Hashtable class?

    What is the difference between Iterator and Enumeration interface in collection framework?

    How can we sort the elements of an object? 

    What is the difference between Comparable and Comparator interfaces?

    What does the hashcode() method?

    What is the difference between Java collection and Java collections?


### Hierarchy of Collection Framework

Let us see the hierarchy of Collection framework. The java.util package contains all the classes and interfaces for the Collection framework.


![Collection](collection.png?raw=true "Collection")


### Iterator interface
Iterator interface provides the facility of iterating the elements in a forward direction only.
Methods of Iterator interface

There are only three methods in the Iterator interface. They are: 


| No.	| Method	| Description |
| ------------- | ------------- | ------------- |
| 1	| public boolean hasNext()	| It returns true if the iterator has more elements otherwise it returns false. |
| 2	| public Object next()	| It returns the element and moves the cursor pointer to the next element. |
| 3	| public void remove()	| It removes the last elements returned by the iterator. It is less used. |

### Iterable Interface

The Iterable interface is the root interface for all the collection classes. The Collection interface extends the Iterable interface and therefore all the subclasses of Collection interface also implement the Iterable interface.

It contains only one abstract method. i.e.,