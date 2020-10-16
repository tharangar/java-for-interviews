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

## Java Throw Keyworkd

The Java throw keyword is used to explicitly throw an exception.

We can throw either checked or uncheked exception in java by throw keyword. The throw keyword is mainly used to throw custom exception. We will see custom exceptions later.

The syntax of java throw keyword is given below. In this example, we have created the validate method that takes integer value as a parameter. If the age is less than 18, we are throwing the ArithmeticException otherwise print a message welcome to vote.

```
    public class TestThrow1{  
       static void validate(int age){  
         if(age<18)  
          throw new ArithmeticException("not valid");  
         else  
          System.out.println("welcome to vote");  
       }  
       public static void main(String args[]){  
          validate(13);  
          System.out.println("rest of the code...");  
      }  
    }  

```

## Java Exception Propagation

An exception is first thrown from the top of the stack and if it is not caught, it drops down the call stack to the previous method,If not caught there, the exception again drops down to the previous method, and so on until they are caught or until they reach the very bottom of the call stack.This is called exception propagation. 

Ex : 

```
    class TestExceptionPropagation1{  
      void m(){  
        int data=50/0;  
      }  
      void n(){  
        m();  
      }  
      void p(){  
       try{  
        n();  
       }catch(Exception e){System.out.println("exception handled");}  
      }  
      public static void main(String args[]){  
       TestExceptionPropagation1 obj=new TestExceptionPropagation1();  
       obj.p();  
       System.out.println("normal flow...");  
      }  
    }  
```
output

```
Output:exception handled
       normal flow...

```

But if we throw a exceoption from method m it will not be propaagted to above layes, so there will be a Compile error as shown in bellow example.


```
    class TestExceptionPropagation2{  
      void m(){  
        throw new java.io.IOException("device error");//checked exception  
      }  
      void n(){  
        m();  
      }  
      void p(){  
       try{  
        n();  
       }catch(Exception e){System.out.println("exception handeled");}  
      }  
      public static void main(String args[]){  
       TestExceptionPropagation2 obj=new TestExceptionPropagation2();  
       obj.p();  
       System.out.println("normal flow");  
      }  
    }  

```
output : Output:Compile Time Error


## Throws Keyword


The Java throws keyword is used to declare an exception. It gives an information to the programmer that there may occur an exception so it is better for the programmer to provide the exception handling code so that normal flow can be maintained.

Exception Handling is mainly used to handle the checked exceptions. If there occurs any unchecked exception such as NullPointerException, it is programmers fault that he is not performing check up before the code being used. Which exception should be declared. checked exceptions only becouse.

* unchecked Exception under programmer control so correct the code.
* errors beyond programmers control.


```
return_type method_name() throws exception_class_name{  
//method code  
}

```

### Advantages of Java throws keyword.

Now Checked Exception can be propagated (forwarded in call stack). 
It provides information to the caller of the mehtod about the exception.


```
    import java.io.IOException;  
    class Testthrows1{  
      void m()throws IOException{  
        throw new IOException("device error");//checked exception  
      }  
      void n()throws IOException{  
        m();  
      }  
      void p(){  
       try{  
        n();  
       }catch(Exception e){System.out.println("exception handled");}  
      }  
      public static void main(String args[]){  
       Testthrows1 obj=new Testthrows1();  
       obj.p();  
       System.out.println("normal flow...");  
      }  
    }  

```

Output :

```
exception handled
normal flow...

```


## Difference between throw and throws in Java

#No | #throw | #throws 
--- | --- | --- 
| 1 | Java throw Keyword is used to explicitly throw an exception. | Java throws Keyword is used to declare an exception 
--- | --- | --- 
 2 | Checked exception cannot be propagated using throw only | Checked exception can be propagated with 
--- | --- | --- 
 3 | throw is followed by an instance. | throws is followed by class. 
--- | --- | --- 
 4 | throw is used within the method. | thows is used with the method signature. 
--- | --- | --- 
 5 | You cannot throw multiple exceptions. | You can declare multiple exceptions e.g.  public coid method()throws IOException, SQLException. 


Java throw and throws example.

```
    void m()throws ArithmeticException{  
    throw new ArithmeticException("sorry");  
    }  
```


##  Difference between final, finally and finalize.

There are many differences between final, finally and finalize. A list of differences between final, finally and finalize are given below


No | final | finally | finalize
--- | --- | --- | ---
1 | Final is used to apply restrictions on classs, method and variable. Final class can't be inherited, final method cant be ovverrden and final variable value cant be changed. | finally is used to place important code, it will be executed whether exception is handled or not. | finalize is used to perform clean up processing just before object is garbage collected. 
 --- | --- | --- | ---
  2 | final is a key word | final isa block | finalize is a method 



#### final example

```
    class FinalExample{  
    public static void main(String[] args){  
    final int x=100;  
    x=200;//Compile Time Error  
    }}  
```

#### finally example

```
    class FinallyExample{  
    public static void main(String[] args){  
    try{  
    int x=300;  
    }catch(Exception e){System.out.println(e);}  
    finally{System.out.println("finally block is executed");}  
    }}  

```

#### finalize example


```
class FinalizeExample{  
public void finalize(){System.out.println("finalize called");}  
public static void main(String[] args){  
FinalizeExample f1=new FinalizeExample();  
FinalizeExample f2=new FinalizeExample();  
f1=null;  
f2=null;  
System.gc();  
}} 

```


## Exception Handling with Method overriding in Java.

There are many rules if we talk about methodoverriding with exception handling. The Rules are as follows:

*    If the superclass method does not declare an exception
        If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.

*    If the superclass method declares an exception
        If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.


Samples.

#### If Supper class method does not declare an exception.

```
    import java.io.*;  
    class Parent{  
      void msg(){System.out.println("parent");}  
    }  
      
    class TestExceptionChild extends Parent{  
      void msg()throws IOException{  
        System.out.println("TestExceptionChild");  
      }  
      public static void main(String args[]){  
       Parent p=new TestExceptionChild();  
       p.msg();  
      }  
    }  
```

This will give an compile error due to 1) Rule: If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception.

output :

```
Output:Compile Time Error
```

Example 2

2) Rule: If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but can declare unchecked exception. 

```
    import java.io.*;  
    class Parent{  
      void msg(){System.out.println("parent");}  
    }  
      
    class TestExceptionChild1 extends Parent{  
      void msg()throws ArithmeticException{  
        System.out.println("child");  
      }  
      public static void main(String args[]){  
       Parent p=new TestExceptionChild1();  
       p.msg();  
      }  
    }  
```

output :
```
Output:child

```


#### If the superclass method declares an exception

1) Rule: If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception. 

Sample : Example in case subclass overridden method declares parent exception.

```
    import java.io.*;  
    class Parent{  
      void msg()throws ArithmeticException{System.out.println("parent");}  
    }  
      
    class TestExceptionChild2 extends Parent{  
      void msg()throws Exception{System.out.println("child");}  
      
      public static void main(String args[]){  
       Parent p=new TestExceptionChild2();  
       try{  
       p.msg();  
       }catch(Exception e){}  
      }  
    }  
```

Above will give a compile error becouse overridden mehtod is declaring parent exception of supper class method exception's.


Example in case subclass overridden mehtod declares same execption.

```
    import java.io.*;  
    class Parent{  
      void msg()throws Exception{System.out.println("parent");}  
    }  
      
    class TestExceptionChild3 extends Parent{  
      void msg()throws Exception{System.out.println("child");}  
      
      public static void main(String args[]){  
       Parent p=new TestExceptionChild3();  
       try{  
       p.msg();  
       }catch(Exception e){}  
      }  
    }  

```

Out put is : child.  

Above senario is possible.


Example in case subclass overridden method declares subclass exception.

```
    import java.io.*;  
    class Parent{  
      void msg()throws Exception{System.out.println("parent");}  
    }  
      
    class TestExceptionChild4 extends Parent{  
      void msg()throws ArithmeticException{System.out.println("child");}  
      
      public static void main(String args[]){  
       Parent p=new TestExceptionChild4();  
       try{  
       p.msg();  
       }catch(Exception e){}  
      }  
    }  

```

Output : child

This senario is allowed.


Example in case subclass overridden method declare no exception.

```
    import java.io.*;  
    class Parent{  
      void msg()throws Exception{System.out.println("parent");}  
    }  
      
    class TestExceptionChild5 extends Parent{  
      void msg(){System.out.println("child");}  
      
      public static void main(String args[]){  
       Parent p=new TestExceptionChild5();  
       try{  
       p.msg();  
       }catch(Exception e){}  
      }  
    }  
```

Output :child



## JAVA Custom Exception.

If you are creating your own Exception that is known as custom exception or user-defined exception. Java custom exceptions are used to customize the exception according to user need.

By the help of custom exception, you can have your own exception and message.

Let's see a simple example of java custom exception.


```
    class InvalidAgeException extends Exception{  
     InvalidAgeException(String s){  
      super(s);  
     }  
    }  


    class TestCustomException1{  
      
       static void validate(int age)throws InvalidAgeException{  
         if(age<18)  
          throw new InvalidAgeException("not valid");  
         else  
          System.out.println("welcome to vote");  
       }  
         
       public static void main(String args[]){  
          try{  
          validate(13);  
          }catch(Exception m){System.out.println("Exception occured: "+m);}  
      
          System.out.println("rest of the code...");  
      }  
    }  


```


How this senario is used in industrial applicaiton can be shown as bellow.

```
package biz.nable.sb.cor.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import biz.nable.sb.cor.common.utility.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public RecordNotFoundException(String message) {
		super(message);
		this.errorCode = ErrorCode.UNKNOWN_ERROR;
	}

	public RecordNotFoundException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public RecordNotFoundException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

}

```


Then it can be thrown from other methods.


```

		} else {
			String msg = messageSource.getMessage(ErrorCode.NO_TEMP_RECORD_FOUND, null,
					LocaleContextHolder.getLocale());
			logger.error(msg);
			throw new RecordNotFoundException(msg, ErrorCode.NO_TEMP_RECORD_FOUND);
		}

```


