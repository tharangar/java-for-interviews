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