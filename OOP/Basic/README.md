
## Learn Java OOP concepts

#### Ref : https://www.javatpoint.com/java-oops-concepts

Following knowledge and ideas abstracted from above mentioned web site.

Advantages of OOP

 1) OOPs makes development and maintenance easier, whereas, in a procedure-oriented programming language, it is not easy to manage if code grows as project size increases.


2) OOPs provides data hiding, whereas, in a procedure-oriented programming language, global data can be accessed from anywhere. 


3) OOPs provides the ability to simulate real-world event much more effectively. We can provide the solution of real word problem if we are using the Object-Oriented Programming language.

### Objeect

An Object can be defined as an instance of a class. An object contains an address and takes up some space in memory. Objects can communicate without knowing the details of each other's data or code. The only necessary thing is the type of message accepted and the type of response returned by the objects.

### Class

A class can also be defined as a blueprint from which you can create an individual object. Class doesn't consume any space.

A class in Java can contain:

*    Fields
*    Methods
*    Constructors
*    Blocks
*    Nested class and interface


### Inheritance

When one object acquires all the properties and behaviors of a parent object, it is known as inheritance. It provides code reusability. It is used to achieve runtime polymorphism.

### Polymorphism

If one task is performed in different ways, it is known as polymorphism. For example: to convince the customer differently, to draw something, for example, shape, triangle, rectangle, etc.

In Java, we use method overloading and method overriding to achieve polymorphism.

### Abstraction

Hiding internal details and showing functionality is known as abstraction.
In Java, we use abstract class and interface to achieve abstraction.

### Encapsulation

Binding (or wrapping) code and data together into a single unit are known as encapsulation.  A java class is the example of encapsulation. Java bean is the fully encapsulated class because all the data members are private here.


### Coupling


Coupling refers to the knowledge or information or dependency of another class. It arises when classes are aware of each other. If a class has the details information of another class, there is strong coupling. In Java, we use private, protected, and public modifiers to display the visibility level of a class, method, and field. You can use interfaces for the weaker coupling because there is no concrete implementation.

### Cohesion

Cohesion refers to the level of a component which performs a single well-defined task. A single well-defined task is done by a highly cohesive method. The weakly cohesive method will split the task into separate parts. The java.io package is a highly cohesive package because it has I/O related classes and interface. However, the java.util package is a weakly cohesive package because it has unrelated classes and interfaces.


### Association

Association represents the relationship between the objects. Here, one object can be associated with one object or many objects. There can be four types of association between the objects:

*   One to One
*   One to Many
*   Many to One
*   Many to Many

Let's understand the relationship with real-time examples. For example, One country can have one prime minister (one to one), and a prime minister can have many ministers (one to many). Also, many MP's can have one prime minister (many to one), and many ministers can have many departments (many to many).

Association can be undirectional or bidirectional.

### Aggregation

Aggregation is a way to achieve Association. Aggregation represents the relationship where one object contains other objects as a part of its state. It represents the weak relationship between objects. It is also termed as a has-a relationship in Java. Like, inheritance represents the is-a relationship. It is another way to reuse objects.

### Composition

The composition is also a way to achieve Association. The composition represents the relationship where one object contains other objects as a part of its state. There is a strong relationship between the containing object and the dependent object. It is the state where containing objects do not have an independent existence. If you delete the parent object, all the child objects will be deleted automatically. 


## Java Naming conventions

Java naming convention is a rule to follow as you decide what to name your identifiers such as class, package, variable, constant, method, etc.

But, it is not forced to follow. So, it is known as convention not rule. These conventions are suggested by several Java communities such as Sun Microsystems and Netscape.

All the classes, interfaces, packages, methods and fields of Java programming language are given according to the Java naming convention. If you fail to follow these conventions, it may generate confusion or erroneous code.

### Class

*   It should start with the uppercase letter.
*    It should be a noun such as Color, Button, System, Thread, etc.
*    Use appropriate words, instead of acronyms.

### Interface

*    It should start with the uppercase letter.
*    It should be an adjective such as Runnable, Remote, ActionListener.
*    Use appropriate words, instead of acronyms.

### Method

*    It should start with lowercase letter.
*    It should be a verb such as main(), print(), println().
*    If the name contains multiple words, start it with a lowercase letter          followed by an uppercase letter such as actionPerformed(). 

### Variable

*    It should start with a lowercase letter such as id, name.
*    It should not start with the special characters like & (ampersand), $        (dollar), _ (underscore).
*    If the name contains multiple words, start it with the lowercase letter      followed by an uppercase letter such as firstName, lastName.
*    Avoid using one-character variables such as x, y, z.


### Object and instances

An object has three characteristics:

*    State: represents the data (value) of an object.
*    Behavior: represents the behavior (functionality) of an object such as       deposit, withdraw, etc.
*    Identity: An object identity is typically implemented via a unique ID.       The value of the ID is not visible to the external user. However, it is      used internally by the JVM to identify each object uniquely.

### Instance variable in Java

A variable which is created inside the class but outside the method is known as an instance variable. Instance variable doesn't get memory at compile time. It gets memory at runtime when an object or instance is created. That is why it is known as an instance variable.


### Method

In Java, a method is like a function which is used to expose the behavior of an object. Advantages of methods are.

*    Code Reusability
*    Code Optimization

### new keyword in Java

The new keyword is used to allocate memory at runtime. All objects get memory in Heap memory area.


#### Object and Class Example: main within the class

In this example, we have created a Student class which has two data members id and name. We are creating the object of the Student class by new keyword and printing the object's value.

Here, we are creating a main() method inside the class.

File: Student.java

```
    //Java Program to illustrate how to define a class and fields  
    //Defining a Student class.  
    class Student{  
     //defining fields  
     int id;//field or data member or instance variable  
     String name;  
     //creating main method inside the Student class  
     public static void main(String args[]){  
      //Creating an object or instance  
      Student s1=new Student();//creating an object of Student  
      //Printing values of the object  
      System.out.println(s1.id);//accessing member through reference variable  
      System.out.println(s1.name);  
     }  
    }  
```

#### Object and Class Example: main outside the class

In real time development, we create classes and use it from another class. It is a better approach than previous one. Let's see a simple example, where we are having main() method in another class.

We can have multiple classes in different Java files or single Java file. If you define multiple classes in a single Java source file, it is a good idea to save the file name with the class name which has main() method.

File: TestStudent1.java

```
    //Java Program to demonstrate having the main method in   
    //another class  
    //Creating Student class.  
    class Student{  
     int id;  
     String name;  
    }  
    //Creating another class TestStudent1 which contains the main method  
    class TestStudent1{  
     public static void main(String args[]){  
      Student s1=new Student();  
      System.out.println(s1.id);  
      System.out.println(s1.name);  
     }  
    }  
```

When compile and run both above files give same output

```
0 
null
```

3 Ways to initialize object

There are 3 ways to initialize object in Java.

1    By reference variable
2    By method
3    By constructor

### 1 Initialization through reference

Initializing an object means storing data into the object. Let's see a simple example where we are going to initialize the object through a reference variable. We can also create multiple objects and store information in it through reference variable.

```
      class Student{  
     int id;  
     String name;  
    }  
    class TestStudent3{  
     public static void main(String args[]){  
      //Creating objects  
      Student s1=new Student();  
      Student s2=new Student();  
      //Initializing objects  
      s1.id=101;  
      s1.name="Sonoo";  
      s2.id=102;  
      s2.name="Amit";  
      //Printing data  
      System.out.println(s1.id+" "+s1.name);  
      System.out.println(s2.id+" "+s2.name);  
     }  
    }  
```


### 2 Initialization through method

In this example, we are creating the two objects of Student class and initializing the value to these objects by invoking the insertRecord method. Here, we are displaying the state (data) of the objects by invoking the displayInformation() method.


```
    class Student{  
     int rollno;  
     String name;  
     void insertRecord(int r, String n){  
      rollno=r;  
      name=n;  
     }  
     void displayInformation(){System.out.println(rollno+" "+name);}  
    }  
    class TestStudent4{  
     public static void main(String args[]){  
      Student s1=new Student();  
      Student s2=new Student();  
      s1.insertRecord(111,"Karan");  
      s2.insertRecord(222,"Aryan");  
      s1.displayInformation();  
      s2.displayInformation();  
     }  
    }  
```


As you can see in the bellow figure, object gets the memory in heap memory area. The reference variable refers to the object allocated in the heap memory area. Here, s1 and s2 both are reference variables that refer to the objects allocated in memory.


![memory heap and stack](https://github.com/tharangar/java-for-interviews/tree/master/OOP/Basic/heap.png)