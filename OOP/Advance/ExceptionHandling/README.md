# JAVA EXCEPTION HANDLING.

https://www.javatpoint.com/exception-handling-in-java


Exception Handling is a mechanism to handle runtime errors such as ClassNotFoundException, IOException, SQLException, RemoteException, etc


The core advantage of exception handling is to maintain the normal flow of the application. An exception normally disrupts the normal flow of the application that is why we use exception handling.

The java.lang.Throwable class is the root class of Java Exception hierarchy which is inherited by two subclasses: Exception and Error. A hierarchy of Java Exception classes are given below:

![Hierarchy of Java Excepton classes](one.PNG?raw=true "Hierarchy")

![Spring Boot Actuator ](images/actuator.PNG?raw=true "ACTUATOR")


There are mainly two types of exceptions: checked and unchecked. Here, an error is considered as the unchecked exception. According to Oracle, there are three types of exceptions:


### 1) Checked Exception

The classes which directly inherit Throwable class except RuntimeException and Error are known as checked exceptions e.g. IOException, SQLException etc. Checked exceptions are checked at compile-time.

### 2) Unchecked Exception

The classes which inherit RuntimeException are known as unchecked exceptions e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc. Unchecked exceptions are not checked at compile-time, but they are checked at runtime.

### 3) Error

Error is irrecoverable e.g. OutOfMemoryError, VirtualMachineError, AssertionError etc.


There are 5 keywords which are used in handling exceptions in Java.

* try

The "try" keyword is used to specify a block where we should place exception code. The try block must be followed by either catch or finally. It means, we can't use try block alone.

* catch

The "catch" block is used to handle the exception. It must be preceded by try block which means we can't use catch block alone. It can be followed by finally block later.


* finally

The "finally" block is used to execute the important code of the program. It is executed whether an exception is handled or not.

* throw

The "throw" keyword is used to throw an exception.

* throws

The "throws" keyword is used to declare exceptions. It doesn't throw an exception. It specifies that there may occur an exception in the method. It is always used with method signature.


Let's see an example of Java Exception Handling where we using a try-catch statement to handle the exception


```
    public class JavaExceptionExample{  
      public static void main(String args[]){  
       try{  
          //code that may raise exception  
          int data=100/0;  
       }catch(ArithmeticException e){System.out.println(e);}  
       //rest code of the program   
       System.out.println("rest of the code...");  
      }  
    }  

```

In this example, we handle the generated exception (Arithmetic Exception) with a different type of exception class (ArrayIndexOutOfBoundsException).


```


```

