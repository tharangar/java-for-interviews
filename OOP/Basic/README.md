
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

![Alt text](relative/path/to/img.jpg?raw=true "Title")
![Alt text](heap.png?raw=true "Heap and stack in memory")
![memory heap and stack](https://absoluteurl/heap.png)


### 3 Initialization through a constructor

This part will be covered when we study the constructors.



### Let's see an example where we are maintaining records of employees.

```
    class Employee{  
        int id;  
        String name;  
        float salary;  
        void insert(int i, String n, float s) {  
            id=i;  
            name=n;  
            salary=s;  
        }  
        void display(){System.out.println(id+" "+name+" "+salary);}  
    }  
    public class TestEmployee {  
    public static void main(String[] args) {  
        Employee e1=new Employee();  
        Employee e2=new Employee();  
        Employee e3=new Employee();  
        e1.insert(101,"ajeet",45000);  
        e2.insert(102,"irfan",25000);  
        e3.insert(103,"nakul",55000);  
        e1.display();  
        e2.display();  
        e3.display();  
    }  
    }  
```


What are the different ways to create an object in Java?

There are many ways to create an object in java. They are:

*    By new keyword
*    By newInstance() method
*    By clone() method
*    By deserialization
*    By factory method etc.

We will learn these ways to create object later.



### Anonymous object


Anonymous simply means nameless. An object which has no reference is known as an anonymous object. It can be used at the time of object creation only.

If you have to use an object only once, an anonymous object is a good approach. For example:

    new Calculation();//anonymous object  

Calling method through a reference:

    Calculation c=new Calculation();  
    c.fact(5);  

Calling method through an anonymous object

    new Calculation().fact(5);  

Let's see the full example of an anonymous object in Java.

```
    class Calculation{  
     void fact(int  n){  
      int fact=1;  
      for(int i=1;i<=n;i++){  
       fact=fact*i;  
      }  
     System.out.println("factorial is "+fact);  
    }  
    public static void main(String args[]){  
     new Calculation().fact(5);//calling method with anonymous object  
    }  
    }  
```


### Creating multiple objects by one type only

We can create multiple objects by one type only as we do in case of primitives.

Initialization of primitive variables:

        int a=10, b=20;  

Initialization of refernce variables:

        Rectangle r1=new Rectangle(), r2=new Rectangle();//creating two objects  


### Constructors in Java

In Java, a constructor is a block of codes similar to the method. 
It is called when an instance of the class is created. At the time of calling constructor, memory for the object is allocated in the memory.

It is a special type of method which is used to initialize the object.

Every time an object is created using the new() keyword, at least one constructor is called.

It calls a default constructor if there is no constructor available in the class. In such case, Java compiler provides a default constructor by default.

There are two types of constructors in Java: no-arg constructor, and parameterized constructor.

Note: It is called constructor because it constructs the values at the time of object creation. It is not necessary to write a constructor for a class. It is because java compiler creates a default constructor if your class doesn't have any.


Rules for creating Java constructor

There are two rules defined for the constructor.

1    Constructor name must be the same as its class name
2    A Constructor must have no explicit return type
3    A Java constructor cannot be abstract, static, final, and synchronized

Note: We can use access modifiers while declaring a constructor. It controls the object creation. In other words, we can have private, protected, public or default constructor in Java.

Types of Java constructors

There are two types of constructors in Java:

    Default constructor (no-arg constructor)
    Parameterized constructor


### Java Default Constructor

A constructor is called "Default Constructor" when it doesn't have any parameter. 

In this example, we are creating the no-arg constructor in the Bike class. It will be invoked at the time of object creation. 

```
//Java Program to create and call a default constructor  
class Bike1{  
//creating a default constructor  
Bike1(){System.out.println("Bike is created");}  
//main method  
public static void main(String args[]){  
//calling a default constructor  
Bike1 b=new Bike1();  
}  
} 
```

The default constructor is used to provide the default values to the object like 0, null, etc., depending on the type. 

### Java Parameterized Constructor

A constructor which has a specific number of parameters is called a parameterized constructor. 

In this example, we have created the constructor of Student class that have two parameters. We can have any number of parameters in the constructor. 

```
    //Java Program to demonstrate the use of the parameterized constructor.  
    class Student4{  
        int id;  
        String name;  
        //creating a parameterized constructor  
        Student4(int i,String n){  
        id = i;  
        name = n;  
        }  
        //method to display the values  
        void display(){System.out.println(id+" "+name);}  
       
        public static void main(String args[]){  
        //creating objects and passing values  
        Student4 s1 = new Student4(111,"Karan");  
        Student4 s2 = new Student4(222,"Aryan");  
        //calling method to display the values of object  
        s1.display();  
        s2.display();  
       }  
    }  
```

### Constructor Overloading in Java

In Java, a constructor is just like a method but without return type. It can also be overloaded like Java methods.

Constructor overloading in Java is a technique of having more than one constructor with different parameter lists. They are arranged in a way that each constructor performs a different task. They are differentiated by the compiler by the number of parameters in the list and their types. 

```
    //Java program to overload constructors  
    class Student5{  
        int id;  
        String name;  
        int age;  
        //creating two arg constructor  
        Student5(int i,String n){  
        id = i;  
        name = n;  
        }  
        //creating three arg constructor  
        Student5(int i,String n,int a){  
        id = i;  
        name = n;  
        age=a;  
        }  
        void display(){System.out.println(id+" "+name+" "+age);}  
       
        public static void main(String args[]){  
        Student5 s1 = new Student5(111,"Karan");  
        Student5 s2 = new Student5(222,"Aryan",25);  
        s1.display();  
        s2.display();  
       }  
    }  
```


In Java, a constructor is just like a method but without return type. It can also be overloaded like Java methods.

Constructor overloading in Java is a technique of having more than one constructor with different parameter lists. They are arranged in a way that each constructor performs a different task. They are differentiated by the compiler by the number of parameters in the list and their types. 


### Difference between constructor and method in Java

There are many differences between constructors and methods. They are given below.


Java Constructor | Java Methods |
--- | --- | 
A constructor is used to initialize the state of an object. | A method is used to expose the behavior of an object. |
A constructor must not have a return type. | A method must have a return type. |
The constructor is invoked implicitly. | The method is invoked explicitly. |
The Java compiler provides a default constructor if you don't have any constructor in a class. | The method is not provided by the compiler in any case. |
The constructor name must be same as the class name. | The method name may or may not be same as the class name. |



### Java Copy Constructor

There is no copy constructor in Java. However, we can copy the values from one object to another like copy constructor in C++.

There are many ways to copy the values of one object into another in Java. They are:

    By constructor
    By assigning the values of one object into another
    By clone() method of Object class

In this example, we are going to copy the values of one object into another using Java constructor.

```
    //Java program to initialize the values from one object to another object.  
    class Student6{  
        int id;  
        String name;  
        //constructor to initialize integer and string  
        Student6(int i,String n){  
        id = i;  
        name = n;  
        }  
        //constructor to initialize another object  
        Student6(Student6 s){  
        id = s.id;  
        name =s.name;  
        }  
        void display(){System.out.println(id+" "+name);}  
       
        public static void main(String args[]){  
        Student6 s1 = new Student6(111,"Karan");  
        Student6 s2 = new Student6(s1);  
        s1.display();  
        s2.display();  
       }  
    }  
```


Q) Does constructor return any value?

Yes, it is the current class instance (You cannot use return type yet it returns a value).
Can constructor perform other tasks instead of initialization?

Yes, like object creation, starting a thread, calling a method, etc. You can perform any operation in the constructor as you perform in the method.
Is there Constructor class in Java?

Yes.
What is the purpose of Constructor class?

Java provides a Constructor class which can be used to get the internal information of a constructor in the class. It is found in the java.lang.reflect package.



### Java static keyword

The static keyword in Java is used for memory management mainly. We can apply java static keyword with variables, methods, blocks and nested class. The static keyword belongs to the class than an instance of the class.

The static can be:

1    Variable (also known as a class variable)
2    Method (also known as a class method)
3    Block
4    Nested class


1) Java static variable

If you declare any variable as static, it is known as a static variable.

    The static variable can be used to refer to the common property of all objects (which is not unique for each object), for example, the company name of employees, college name of students, etc.
    The static variable gets memory only once in the class area at the time of class loading.


One advantage of static variable is, it makes your program memory efficient (i.e., it saves memory).

Suppose there are 500 students in my college, now all instance data members will get memory each time when the object is created. All students have its unique rollno and name, so instance data member is good in such case. Here, "college" refers to the common property of all objects. If we make it static, this field will get the memory only once.

```
/Java Program to demonstrate the use of static variable  
class Student{  
   int rollno;//instance variable  
   String name;  
   static String college ="ITS";//static variable  
   //constructor  
   Student(int r, String n){  
   rollno = r;  
   name = n;  
   }  
   //method to display the values  
   void display (){System.out.println(rollno+" "+name+" "+college);}  
}  
//Test class to show the values of objects  
public class TestStaticVariable1{  
 public static void main(String args[]){  
 Student s1 = new Student(111,"Karan");  
 Student s2 = new Student(222,"Aryan");  
 //we can change the college of all objects by the single line of code  
 //Student.college="BBDIT";  
 s1.display();  
 s2.display();  
 }  
}  
```

![Alt text](static.png?raw=true "Static variables")


### 2) Java static method

If you apply static keyword with any method, it is known as static method.

    A static method belongs to the class rather than the object of a class.
    A static method can be invoked without the need for creating an instance of a class.
    A static method can access static data member and can change the value of it.

### Example of a static method that performs a normal calculation

```
    //Java Program to get the cube of a given number using the static method  
      
    class Calculate{  
      static int cube(int x){  
      return x*x*x;  
      }  
      
      public static void main(String args[]){  
      int result=Calculate.cube(5);  
      System.out.println(result);  
      }  
    }  
```

### Restrictions for the static method

There are two main restrictions for the static method. They are:

    The static method can not use non static data member or call non-static method directly.
    this and super cannot be used in static context.

Q) Why is the Java main method static?

Ans) It is because the object is not required to call a static method. If it were a non-static method, JVM creates an object first then call main() method that will lead the problem of extra memory allocation.



### 3) Java static block

    Is used to initialize the static data member.
    It is executed before the main method at the time of classloading.

```
class A2{  
  static{System.out.println("static block is invoked");}  
  public static void main(String args[]){  
   System.out.println("Hello main");  
  }  
}
```

Q) Can we execute a program without main() method?

Ans) No, one of the ways was the static block, but it was possible till JDK 1.6. Since JDK 1.7, it is not possible to execute a java class without the main method.


### this keyword in java

There can be a lot of usage of java this keyword. In java, this is a reference variable that refers to the current object.

Usage of java this keyword

Here is given the 6 usage of java this keyword.

    this can be used to refer current class instance variable.
    this can be used to invoke current class method (implicitly)
    this() can be used to invoke current class constructor.
    this can be passed as an argument in the method call.
    this can be passed as argument in the constructor call.
    this can be used to return the current class instance from the method.

Suggestion: If you are beginner to java, lookup only three usage of this keyword.

The this keyword can be used to refer current class instance variable. If there is ambiguity between the instance variables and parameters, this keyword resolves the problem of ambiguity. 

```
    class Student{  
    int rollno;  
    String name;  
    float fee;  
    Student(int rollno,String name,float fee){  
    this.rollno=rollno;  
    this.name=name;  
    this.fee=fee;  
    }  
    void display(){System.out.println(rollno+" "+name+" "+fee);}  
    }  
      
    class TestThis2{  
    public static void main(String args[]){  
    Student s1=new Student(111,"ankit",5000f);  
    Student s2=new Student(112,"sumit",6000f);  
    s1.display();  
    s2.display();  
    }}  
```

It is better approach to use meaningful names for variables. So we use same name for instance variables and parameters in real time, and always use this keyword.


### 3) this() : to invoke current class constructor

The this() constructor call can be used to invoke the current class constructor. It is used to reuse the constructor. In other words, it is used for constructor chaining.

```
    class A{  
    A(){System.out.println("hello a");}  
    A(int x){  
    this();  
    System.out.println(x);  
    }  
    }  
    class TestThis5{  
    public static void main(String args[]){  
    A a=new A(10);  
    }}  
```

Calling parameterized constructor from default constructor:

```
    class A{  
    A(){  
    this(5);  
    System.out.println("hello a");  
    }  
    A(int x){  
    System.out.println(x);  
    }  
    }  
    class TestThis6{  
    public static void main(String args[]){  
    A a=new A();  
    }}  
```

### Real usage of this() constructor call

The this() constructor call should be used to reuse the constructor from the constructor. It maintains the chain between the constructors i.e. it is used for constructor chaining. Let's see the example given below that displays the actual use of this keyword.

```
    class Student{  
    int rollno;  
    String name,course;  
    float fee;  
    Student(int rollno,String name,String course){  
    this.rollno=rollno;  
    this.name=name;  
    this.course=course;  
    }  
    Student(int rollno,String name,String course,float fee){  
    this(rollno,name,course);//reusing constructor  
    this.fee=fee;  
    }  
    void display(){System.out.println(rollno+" "+name+" "+course+" "+fee);}  
    }  
    class TestThis7{  
    public static void main(String args[]){  
    Student s1=new Student(111,"ankit","java");  
    Student s2=new Student(112,"sumit","java",6000f);  
    s1.display();  
    s2.display();  
    }}  

```

### 4) this: to pass as an argument in the method

The this keyword can also be passed as an argument in the method. It is mainly used in the event handling. Let's see the example:

```
    class S2{  
      void m(S2 obj){  
      System.out.println("method is invoked");  
      }  
      void p(){  
      m(this);  
      }  
      public static void main(String args[]){  
      S2 s1 = new S2();  
      s1.p();  
      }  
    }  

```


Application of this that can be passed as an argument:

In event handling (or) in a situation where we have to provide reference of a class to another one. It is used to reuse one object in many methods.


### 5) this: to pass as argument in the constructor call

We can pass the this keyword in the constructor also. It is useful if we have to use one object in multiple classes. Let's see the example:

```
    class B{  
      A4 obj;  
      B(A4 obj){  
        this.obj=obj;  
      }  
      void display(){  
        System.out.println(obj.data);//using data member of A4 class  
      }  
    }  
      
    class A4{  
      int data=10;  
      A4(){  
       B b=new B(this);  
       b.display();  
      }  
      public static void main(String args[]){  
       A4 a=new A4();  
      }  
    }  
```

### 6) this keyword can be used to return current class instance

We can return this keyword as an statement from the method. In such case, return type of the method must be the class type (non-primitive). Let's see the example:
Syntax of this that can be returned as a statement

```

class A{  
A getA(){  
return this;  
}  
void msg(){System.out.println("Hello java");}  
}  
class Test1{  
public static void main(String args[]){  
new A().getA().msg();  
}  
} 

```

### Proving this keyword

Let's prove that this keyword refers to the current class instance variable. In this program, we are printing the reference variable and this, output of both variables are same.

```
class A5{  
void m(){  
System.out.println(this);//prints same reference ID  
}  
public static void main(String args[]){  
A5 obj=new A5();  
System.out.println(obj);//prints the reference ID  
obj.m();  
}  
} 

```

