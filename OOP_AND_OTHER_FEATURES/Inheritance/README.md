# Inheritance in Java 


## Is -A relationship

Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object. It is an important part of OOPs (Object Oriented programming system).

The idea behind inheritance in Java is that you can create new classes that are built upon existing classes. When you inherit from an existing class, you can reuse methods and fields of the parent class. Moreover, you can add new methods and fields in your current class also.

Inheritance represents the IS-A relationship which is also known as a parent-child relationship.

### Why use inheritance in java

    For Method Overriding (so runtime polymorphism can be achieved).
    For Code Reusability.


### Terms used in Inheritance

    Class: A class is a group of objects which have common properties. It is a template or blueprint from which objects are created.
    Sub Class/Child Class: Subclass is a class which inherits the other class. It is also called a derived class, extended class, or child class.
    Super Class/Parent Class: Superclass is the class from where a subclass inherits the features. It is also called a base class or a parent class.
    Reusability: As the name specifies, reusability is a mechanism which facilitates you to reuse the fields and methods of the existing class when you create a new class. You can use the same fields and methods already defined in the previous class.


### The syntax of Java Inheritance

```
    class Subclass-name extends Superclass-name  
    {  
       //methods and fields  
    }  
```

The extends keyword indicates that you are making a new class that derives from an existing class. The meaning of "extends" is to increase the functionality.

In the terminology of Java, a class which is inherited is called a parent or superclass, and the new class is called child or subclass.




As displayed in the above figure, Programmer is the subclass and Employee is the superclass. The relationship between the two classes is Programmer IS-A Employee. It means that Programmer is a type of Employee.

```
    class Employee{  
     float salary=40000;  
    }  
    class Programmer extends Employee{  
     int bonus=10000;  
     public static void main(String args[]){  
       Programmer p=new Programmer();  
       System.out.println("Programmer salary is:"+p.salary);  
       System.out.println("Bonus of Programmer is:"+p.bonus);  
    }  
    }  
```

In the above example, Programmer object can access the field of own class as well as of Employee class i.e. code reusability. 


Lets discuss with some more examples.

<P>
Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. With the use of inheritance the information is made manageable in a hierarchical order.

The class which inherits the properties of other is known as subclass (derived class, child class) and the class whose properties are inherited is known as superclass (base class, parent class).
</p>

extends is the keyword used to inherit the properties of a class. Following is the syntax of extends keyword.

```
class Super {
   .....
   .....
}
class Sub extends Super {
   .....
   .....
}


```

<h3>
Sample  </h3>

Following is an example demonstrating Java inheritance. In this example, you can observe two classes namely Calculation and My_Calculation.

Using extends keyword, the My_Calculation inherits the methods addition() and Subtraction() of Calculation class.

Copy and paste the following program in a file with name My_Calculation.java

```
class Calculation {
   int z;
	
   public void addition(int x, int y) {
      z = x + y;
      System.out.println("The sum of the given numbers:"+z);
   }
	
   public void Subtraction(int x, int y) {
      z = x - y;
      System.out.println("The difference between the given numbers:"+z);
   }
}

public class My_Calculation extends Calculation {
   public void multiplication(int x, int y) {
      z = x * y;
      System.out.println("The product of the given numbers:"+z);
   }
	
   public static void main(String args[]) {
      int a = 20, b = 10;
      My_Calculation demo = new My_Calculation();
      demo.addition(a, b);
      demo.Subtraction(a, b);
      demo.multiplication(a, b);
   }
}

```

Compile and execute the above code as shown below.

```
javac My_Calculation.java
java My_Calculation

output >>>>>>

The sum of the given numbers:30
The difference between the given numbers:10
The product of the given numbers:200

```


### Types of inheritance in java

On the basis of class, there can be three types of inheritance in java: single, multilevel and hierarchical.

In java programming, multiple and hybrid inheritance is supported through interface only. We will learn about interfaces later.

![Inheritance types](inheritance.png?raw=true "Static variables")


Note: Multiple inheritance is not supported in Java through class.

When one class inherits multiple classes, it is known as multiple inheritance. For Example:

![Inheritance types supported with interfaces](interfaces.png?raw=true "Static variables")


### Multilevel Inheritance Example

```
    class Animal{  
    void eat(){System.out.println("eating...");}  
    }  
    class Dog extends Animal{  
    void bark(){System.out.println("barking...");}  
    }  
    class BabyDog extends Dog{  
    void weep(){System.out.println("weeping...");}  
    }  
    class TestInheritance2{  
    public static void main(String args[]){  
    BabyDog d=new BabyDog();  
    d.weep();  
    d.bark();  
    d.eat();  
    }}  

```
output

```
weeping...
barking...
eating...

```

### Hierarchical Inheritance Example

```
    class Animal{  
    void eat(){System.out.println("eating...");}  
    }  
    class Dog extends Animal{  
    void bark(){System.out.println("barking...");}  
    }  
    class Cat extends Animal{  
    void meow(){System.out.println("meowing...");}  
    }  
    class TestInheritance3{  
    public static void main(String args[]){  
    Cat c=new Cat();  
    c.meow();  
    c.eat();  
    //c.bark();//C.T.Error  
    }}  

```


### Q) Why multiple inheritance is not supported in java?

To reduce the complexity and simplify the language, multiple inheritance is not supported in java.

Consider a scenario where A, B, and C are three classes. The C class inherits A and B classes. If A and B classes have the same method and you call it from child class object, there will be ambiguity to call the method of A or B class.

Since compile-time errors are better than runtime errors, Java renders compile-time error if you inherit 2 classes. So whether you have same method or different, there will be compile time error.


## Aggregation in Java (HAS-A relationship)

If a class have an entity reference, it is known as Aggregation. Aggregation represents HAS-A relationship.

Consider a situation, Employee object contains many informations such as id, name, emailId etc. It contains one more object named address, which contains its own informations such as city, state, country, zipcode etc. as given below. 

```
class Employee{  
int id;  
String name;  
Address address;//Address is a class  
...  
} 
```


 In such case, Employee has an entity reference address, so relationship is Employee HAS-A address.
Why use Aggregation?

    For Code Reusability.


In this example, we have created the reference of Operation class in the Circle class. 

```
    class Operation{  
     int square(int n){  
      return n*n;  
     }  
    }  
      
    class Circle{  
     Operation op;//aggregation  
     double pi=3.14;  
        
     double area(int radius){  
       op=new Operation();  
       int rsquare=op.square(radius);//code reusability (i.e. delegates the method call).  
       return pi*rsquare;  
     }  
      
         
        
     public static void main(String args[]){  
       Circle c=new Circle();  
       double result=c.area(5);  
       System.out.println(result);  
     }  
    }  
```

### When use Aggregation?

    Code reuse is also best achieved by aggregation when there is no is-a relationship.
    Inheritance should be used only if the relationship is-a is maintained throughout the lifetime of the objects involved; otherwise, aggregation is the best choice.

### Understanding meaningful example of Aggregation

In this example, Employee has an object of Address, address object contains its own informations such as city, state, country etc. In such case relationship is Employee HAS-A address. 

Address.java

```
    public class Address {  
    String city,state,country;  
      
    public Address(String city, String state, String country) {  
        this.city = city;  
        this.state = state;  
        this.country = country;  
    }  
      
    }  
```

Emp.java

```
    public class Emp {  
    int id;  
    String name;  
    Address address;  
      
    public Emp(int id, String name,Address address) {  
        this.id = id;  
        this.name = name;  
        this.address=address;  
    }  
      
    void display(){  
    System.out.println(id+" "+name);  
    System.out.println(address.city+" "+address.state+" "+address.country);  
    }  
      
    public static void main(String[] args) {  
    Address address1=new Address("gzb","UP","india");  
    Address address2=new Address("gno","UP","india");  
      
    Emp e=new Emp(111,"varun",address1);  
    Emp e2=new Emp(112,"arun",address2);  
          
    e.display();  
    e2.display();  
          
    }  
    }  

```

