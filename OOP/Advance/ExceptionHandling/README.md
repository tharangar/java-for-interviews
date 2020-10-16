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

How Exception works in JVM and java application.

![Hierarchy of Java Excepton classes](two.PNG?raw=true "Hierarchy")


In this example, we handle the generated exception (Arithmetic Exception) with a different type of exception class (ArrayIndexOutOfBoundsException).


```
    public class TryCatchExample8 {  
      
        public static void main(String[] args) {  
            try  
            {  
            int data=50/0; //may throw exception   
      
            }  
                // try to handle the ArithmeticException using ArrayIndexOutOfBoundsException  
            catch(ArrayIndexOutOfBoundsException e)  
            {  
                System.out.println(e);  
            }  
            System.out.println("rest of the code");  
        }  
          
    }  

```

Output :

```
Exception in thread "main" java.lang.ArithmeticException: / by zero

```

## Java catch multiple exceptions.

A try block can be followed by one or more catch blocks. Each catch block must contain a different exception handler. So, if you have to perform different tasks at the occurrence of different exceptions, use java multi-catch block.

* At a time only one exception occurs and at a time only one catch block is executed.

* All catch blocks must be ordered from most specific to most general, i.e. catch for ArithmeticException must come before catch for Exception.

if handle the exception without maintaining the order of exceptions (i.e. from most specific to most general) there will be a compile error.

In this example, we generate NullPointerException, but didn't provide the corresponding exception type. In such case, the catch block containing the parent exception class Exception will invoked.

```

    public class MultipleCatchBlock4 {  
      
        public static void main(String[] args) {  
              
               try{    
                    String s=null;  
                    System.out.println(s.length());  
                   }    
                   catch(ArithmeticException e)  
                      {  
                       System.out.println("Arithmetic Exception occurs");  
                      }    
                   catch(ArrayIndexOutOfBoundsException e)  
                      {  
                       System.out.println("ArrayIndexOutOfBounds Exception occurs");  
                      }    
                   catch(Exception e)  
                      {  
                       System.out.println("Parent Exception occurs");  
                      }             
                   System.out.println("rest of the code");    
        }  
    }  
```

Result :

```
Parent Exception occurs
rest of the code
```

## Java Nested Try block.


Sometimes a situation may arise where a part of a block may cause one error and the entire block itself may cause another error. In such cases, exception handlers have to be nested.


```
    class Excep6{  
     public static void main(String args[]){  
      try{  
        try{  
         System.out.println("going to divide");  
         int b =39/0;  
        }catch(ArithmeticException e){System.out.println(e);}  
       
        try{  
        int a[]=new int[5];  
        a[5]=4;  
        }catch(ArrayIndexOutOfBoundsException e){System.out.println(e);}  
         
        System.out.println("other statement);  
      }catch(Exception e){System.out.println("handeled");}  
      
      System.out.println("normal flow..");  
     }  
    }  

```


## Finally Block in Exception Handling.



Java finally block is a block that is used to execute important code such as closing connection, stream etc.

Java finally block is always executed whether exception is handled or not.

Java finally block follows try or catch block.

Finally block in java can be used to put "cleanup" code such as closing a file, closing connection etc.


![Finaly block](finaly.PNG?raw=true "Finaly Block")

Excpetion found or not finaly block will be executed.


```
    class TestFinallyBlock1{  
      public static void main(String args[]){  
      try{  
       int data=25/0;  
       System.out.println(data);  
      }  
      catch(NullPointerException e){System.out.println(e);}  
      finally{System.out.println("finally block is always executed");}  
      System.out.println("rest of the code...");  
      }  
    }  

```

output

```
Output:finally block is always executed
       Exception in thread main java.lang.ArithmeticException:/ by zero
```