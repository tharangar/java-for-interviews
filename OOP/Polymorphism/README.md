# Polymorphism in java

## Method Overloading in Java

If a class has multiple methods having same name but different in parameters, it is known as Method Overloading. 

If we have to perform only one operation, having same name of the methods increases the readability of the program.

Suppose you have to perform addition of the given numbers but there can be any number of arguments, if you write the method such as a(int,int) for two parameters, and b(int,int,int) for three parameters then it may be difficult for you as well as other programmers to understand the behavior of the method because its name differs.

So, we perform method overloading to figure out the program quickly.
java method overloading
Advantage of method overloading

Method overloading increases the readability of the program.
Different ways to overload the method

There are two ways to overload the method in java

    By changing number of arguments
    By changing the data type

In java, Method Overloading is not possible by changing the return type of the method only.


### 1) Method Overloading: changing no. of arguments

In this example, we have created two methods, first add() method performs addition of two numbers and second add method performs addition of three numbers.

In this example, we are creating static methods so that we don't need to create instance for calling methods.

```
    class Adder{  
    static int add(int a,int b){return a+b;}  
    static int add(int a,int b,int c){return a+b+c;}  
    }  
    class TestOverloading1{  
    public static void main(String[] args){  
    System.out.println(Adder.add(11,11));  
    System.out.println(Adder.add(11,11,11));  
    }}  
```

### 2) Method Overloading: changing data type of arguments

In this example, we have created two methods that differs in data type. The first add method receives two integer arguments and second add method receives two double arguments.

```
    class Adder{  
    static int add(int a, int b){return a+b;}  
    static double add(double a, double b){return a+b;}  
    }  
    class TestOverloading2{  
    public static void main(String[] args){  
    System.out.println(Adder.add(11,11));  
    System.out.println(Adder.add(12.3,12.6));  
    }}  
```


### Q) Why Method Overloading is not possible by changing the return type of method only?

In java, method overloading is not possible by changing the return type of the method only because of ambiguity. Let's see how ambiguity may occur:

```
    class Adder{  
    static int add(int a,int b){return a+b;}  
    static double add(int a,int b){return a+b;}  
    }  
    class TestOverloading3{  
    public static void main(String[] args){  
    System.out.println(Adder.add(11,11));//ambiguity  
    }} 
```

So above code will give a compile error

    Compile Time Error: method add(int,int) is already defined in class Adder

Note: Compile Time Error is better than Run Time Error. So, java compiler renders compiler time error if you declare the same method having same parameters.

### Can we overload java main() method?

Yes, by method overloading. You can have any number of main methods in a class by method overloading. But JVM calls main() method which receives string array as arguments only. Let's see the simple example: 

Look at bellow example output is only from the one method.

![Main methods](mainmethods.png?raw=true "Main methods")

### Method Overloading and Type Promotion

One type is promoted to another implicitly if no matching datatype is found. Let's understand the concept by the figure given below:
As displayed in the bellow diagram, byte can be promoted to short, int, long, float or double. The short datatype can be promoted to int,long,float or double. The char datatype can be promoted to int,long,float or double and so on.

![Type Promotion](promotion.png?raw=true "Type Promotion")


### Example of Method Overloading with TypePromotion

```
    class OverloadingCalculation1{  
      void sum(int a,long b){System.out.println(a+b);}  
      void sum(int a,int b,int c){System.out.println(a+b+c);}  
      
      public static void main(String args[]){  
      OverloadingCalculation1 obj=new OverloadingCalculation1();  
      obj.sum(20,20);//now second int literal will be promoted to long  
      obj.sum(20,20,20);  
      
      }  
    }  
```


### Example of Method Overloading with Type Promotion if matching found

If there are matching type arguments in the method, type promotion is not performed.

### Example of Method Overloading with Type Promotion in case of ambiguity

If there are no matching type arguments in the method, and each method promotes similar number of arguments, there will be ambiguity.

```
class OverloadingCalculation3{  
  void sum(int a,long b){System.out.println("a method invoked");}  
  void sum(long a,int b){System.out.println("b method invoked");}  
  
  public static void main(String args[]){  
  OverloadingCalculation3 obj=new OverloadingCalculation3();  
  obj.sum(20,20);//now ambiguity  
  }  
} 
```

Output:Compile Time Error



One type is not de-promoted implicitly for example double cannot be depromoted to any type implicitly.


## Method Overriding in Java

If subclass (child class) has the same method as declared in the parent class, it is known as method overriding in Java.

In other words, If a subclass provides the specific implementation of the method that has been declared by one of its parent class, it is known as method overriding.
Usage of Java Method Overriding

    Method overriding is used to provide the specific implementation of a method which is already provided by its superclass.
    Method overriding is used for runtime polymorphism

Rules for Java Method Overriding

    The method must have the same name as in the parent class
    The method must have the same parameter as in the parent class.
    There must be an IS-A relationship (inheritance).

### Example of method overriding

In this example, we have defined the run method in the subclass as defined in the parent class but it has some specific implementation. The name and parameter of the method are the same, and there is IS-A relationship between the classes, so there is method overriding. 

```
    //Java Program to illustrate the use of Java Method Overriding  
    //Creating a parent class.  
    class Vehicle{  
      //defining a method  
      void run(){System.out.println("Vehicle is running");}  
    }  
    //Creating a child class  
    class Bike2 extends Vehicle{  
      //defining the same method as in the parent class  
      void run(){System.out.println("Bike is running safely");}  
      
      public static void main(String args[]){  
      Bike2 obj = new Bike2();//creating object  
      obj.run();//calling method  
      }  
    }  
```

output : Bike is running safely

### A real example of Java Method Overriding

Consider a scenario where Bank is a class that provides functionality to get the rate of interest. However, the rate of interest varies according to banks. For example, SBI, ICICI and AXIS banks could provide 8%, 7%, and 9% rate of interest.


Java method overriding is mostly used in Runtime Polymorphism which we will learn in next.


![overriding](overriding.png?raw=true "Overriding")

```
    //Java Program to demonstrate the real scenario of Java Method Overriding  
    //where three classes are overriding the method of a parent class.  
    //Creating a parent class.  
    class Bank{  
    int getRateOfInterest(){return 0;}  
    }  
    //Creating child classes.  
    class SBI extends Bank{  
    int getRateOfInterest(){return 8;}  
    }  
      
    class ICICI extends Bank{  
    int getRateOfInterest(){return 7;}  
    }  
    class AXIS extends Bank{  
    int getRateOfInterest(){return 9;}  
    }  
    //Test class to create objects and call the methods  
    class Test2{  
    public static void main(String args[]){  
    SBI s=new SBI();  
    ICICI i=new ICICI();  
    AXIS a=new AXIS();  
    System.out.println("SBI Rate of Interest: "+s.getRateOfInterest());  
    System.out.println("ICICI Rate of Interest: "+i.getRateOfInterest());  
    System.out.println("AXIS Rate of Interest: "+a.getRateOfInterest());  
    }  
    }  

```


### Can we override static method?

No, a static method cannot be overridden. It can be proved by runtime polymorphism, so we will learn it later.

### Why can we not override static method?

It is because the static method is bound with class whereas instance method is bound with an object. Static belongs to the class area, and an instance belongs to the heap area.

### Can we override java main method?

https://www.javatpoint.com/method-overriding-in-java



No, because the main is a static method.
Difference between method Overloading and Method Overriding in java

Click me for the difference between method overloading and overriding
More topics on Method Overriding (Not For Beginners)
Method Overriding with Access Modifier

Let's see the concept of method overriding with access modifier.
Exception Handling with Method Overriding

Let's see the concept of method overriding with exception handling.



## Covariant Return Type

The covariant return type specifies that the return type may vary in the same direction as the subclass.

Before Java5, it was not possible to override any method by changing the return type. But now, since Java5, it is possible to override method by changing the return type if subclass overrides any method whose return type is Non-Primitive but it changes its return type to subclass type. Let's take a simple example: 

```
class A{  
A get(){return this;}  
}  
  
class B1 extends A{  
B1 get(){return this;}  
void message(){System.out.println("welcome to covariant return type");}  
  
public static void main(String args[]){  
new B1().get().message();  
}  
}

```

https://www.javatpoint.com/covariant-return-type

Output:welcome to covariant return type

As you can see in the above example, the return type of the get() method of A class is A but the return type of the get() method of B class is B. Both methods have different return type but it is method overriding. This is known as covariant return type.
How is Covariant return types implemented?

Java doesn't allow the return type based overloading but JVM always allows return type based overloading. JVM uses full signature of a method for lookup/resolution. Full signature means it includes return type in addition to argument types. i.e., a class can have two or more methods differing only by return type. javac uses this fact to implement covariant return types.


## Super Keyword in Java

The super keyword in Java is a reference variable which is used to refer immediate parent class object.

Whenever you create the instance of subclass, an instance of parent class is created implicitly which is referred by super reference variable.

Usage of Java super Keyword

1    super can be used to refer immediate parent class instance variable.
2    super can be used to invoke immediate parent class method.
3    super() can be used to invoke immediate parent class constructor.


### 1) super is used to refer immediate parent class instance variable.

We can use super keyword to access the data member or field of parent class. It is used if parent class and child class have same fields.

```
    class Animal{  
    String color="white";  
    }  
    class Dog extends Animal{  
    String color="black";  
    void printColor(){  
    System.out.println(color);//prints color of Dog class  
    System.out.println(super.color);//prints color of Animal class  
    }  
    }  
    class TestSuper1{  
    public static void main(String args[]){  
    Dog d=new Dog();  
    d.printColor();  
    }}  
```

Output:

black
white

In the above example, Animal and Dog both classes have a common property color. If we print color property, it will print the color of current class by default. To access the parent property, we need to use super keyword. 

The super keyword can also be used to invoke parent class method. It should be used if subclass contains the same method as parent class. In other words, it is used if method is overridden.

```
    class Animal{  
    void eat(){System.out.println("eating...");}  
    }  
    class Dog extends Animal{  
    void eat(){System.out.println("eating bread...");}  
    void bark(){System.out.println("barking...");}  
    void work(){  
    super.eat();  
    bark();  
    }  
    }  
    class TestSuper2{  
    public static void main(String args[]){  
    Dog d=new Dog();  
    d.work();  
    }}  

```
Test it Now

Output:

eating...
barking...

In the above example Animal and Dog both classes have eat() method if we call eat() method from Dog class, it will call the eat() method of Dog class by default because priority is given to local.

To call the parent class method, we need to use super keyword.


### 3) super is used to invoke parent class constructor.

The super keyword can also be used to invoke the parent class constructor. Let's see a simple example:

```
    class Animal{  
    Animal(){System.out.println("animal is created");}  
    }  
    class Dog extends Animal{  
    Dog(){  
    super();  
    System.out.println("dog is created");  
    }  
    }  
    class TestSuper3{  
    public static void main(String args[]){  
    Dog d=new Dog();  
    }}  
```
output is 

```
animal is created
dog is created

```

Note: super() is added in each class constructor automatically by compiler if there is no super() or this().


![supper](supper.png?raw=true "supper")

As we know well that default constructor is provided by compiler automatically if there is no constructor. But, it also adds super() as the first statement.

#### Another example of super keyword where super() is provided by the compiler implicitly.

```
class Animal{  
Animal(){System.out.println("animal is created");}  
}  
class Dog extends Animal{  
Dog(){  
System.out.println("dog is created");  
}  
}  
class TestSuper4{  
public static void main(String args[]){  
Dog d=new Dog();  
}} 

```
So it's output is same as the previous one.

### super example: real use

Let's see the real use of super keyword. Here, Emp class inherits Person class so all the properties of Person will be inherited to Emp by default. To initialize all the property, we are using parent class constructor from child class. In such way, we are reusing the parent class constructor. 

```
    class Person{  
    int id;  
    String name;  
    Person(int id,String name){  
    this.id=id;  
    this.name=name;  
    }  
    }  
    class Emp extends Person{  
    float salary;  
    Emp(int id,String name,float salary){  
    super(id,name);//reusing parent constructor  
    this.salary=salary;  
    }  
    void display(){System.out.println(id+" "+name+" "+salary);}  
    }  
    class TestSuper5{  
    public static void main(String[] args){  
    Emp e1=new Emp(1,"ankit",45000f);  
    e1.display();  
    }}  

```

output
1 ankit 45000


## Instance initializer block

Instance Initializer block is used to initialize the instance data member. It run each time when object of the class is created.
The initialization of the instance variable can be done directly but there can be performed extra operations while initializing the instance variable in the instance initializer block.

Que) What is the use of instance initializer block while we can directly assign a value in instance data member? For example:

```
    class Bike{  
        int speed=100;  
    }  
```

Suppose I have to perform some operations while assigning value to instance data member e.g. a for loop to fill a complex array or error handling etc.
Let's see the simple example of instance initializer block that performs initialization.

```
    class Bike7{  
        int speed;  
          
        Bike7(){System.out.println("speed is "+speed);}  
       
        {speed=100;}  
           
        public static void main(String args[]){  
        Bike7 b1=new Bike7();  
        Bike7 b2=new Bike7();  
        }      
    }  
```

output
Output:speed is 100
       speed is 100


### There are three places in java where you can perform operations:

    method
    constructor
    block

What is invoked first, instance initializer block or constructor?

```
    class Bike8{  
        int speed;  
          
        Bike8(){System.out.println("constructor is invoked");}  
       
        {System.out.println("instance initializer block invoked");}  
           
        public static void main(String args[]){  
        Bike8 b1=new Bike8();  
        Bike8 b2=new Bike8();  
        }      
    }  

```


output

```
       instance initializer block invoked
       constructor is invoked
       instance initializer block invoked
       constructor is invoked
```


In the above example, it seems that instance initializer block is firstly invoked but NO. Instance intializer block is invoked at the time of object creation. The java compiler copies the instance initializer block in the constructor after the first statement super(). So firstly, constructor is invoked. Let's understand it by the figure given below:
Note: The java compiler copies the code of instance initializer block in every constructor

![Instance Block](instance-block.png?raw=true "instance block")


### Rules for instance initializer block :
There are mainly three rules for the instance initializer block. They are as follows:

    The instance initializer block is created when instance of the class is created.
    The instance initializer block is invoked after the parent class constructor is invoked (i.e. after super() constructor call).
    The instance initializer block comes in the order in which they appear.

### Program of instance initializer block that is invoked after super()

```
    class A{  
    A(){  
    System.out.println("parent class constructor invoked");  
    }  
    }  
    class B2 extends A{  
    B2(){  
    super();  
    System.out.println("child class constructor invoked");  
    }  
      
    {System.out.println("instance initializer block is invoked");}  
      
    public static void main(String args[]){  
    B2 b=new B2();  
    }  
    }  

```

output
```
Output:parent class constructor invoked
       instance initializer block is invoked
       child class constructor invoked
```


### Another Example of instance block

```
    class A{  
    A(){  
    System.out.println("parent class constructor invoked");  
    }  
    }  
      
    class B3 extends A{  
    B3(){  
    super();  
    System.out.println("child class constructor invoked");  
    }  
      
    B3(int a){  
    super();  
    System.out.println("child class constructor invoked "+a);  
    }  
      
    {System.out.println("instance initializer block is invoked");}  
      
    public static void main(String args[]){  
    B3 b1=new B3();  
    B3 b2=new B3(10);  
    }  
    }  
```