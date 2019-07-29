
## Multithreading in Java

https://www.javatpoint.com/multithreading-in-java


Multithreading in java is a process of executing multiple threads simultaneously.

A thread is a lightweight sub-process, the smallest unit of processing. Multiprocessing and multithreading, both are used to achieve multitasking.

However, we use multithreading than multiprocessing because threads use a shared memory area. They don't allocate separate memory area so saves memory, and context-switching between the threads takes less time than process. 
Java Multithreading is mostly used in games, animation, etc.

### Advantages of Java Multithreading

1) It doesn't block the user because threads are independent and you can perform multiple operations at the same time.

2) You can perform many operations together, so it saves time.

3) Threads are independent, so it doesn't affect other threads if an exception occurs in a single thread.

### Multitasking

Multitasking is a process of executing multiple tasks simultaneously. We use multitasking to utilize the CPU. Multitasking can be achieved in two ways:

    1.  Process-based Multitasking (Multiprocessing)
    2.  Thread-based Multitasking (Multithreading)

### 1) Process-based Multitasking (Multiprocessing)

    Each process has an address in memory. In other words, each process allocates a separate memory area.

    A process is heavyweight.

    Cost of communication between the process is high.

    Switching from one process to another requires some time for saving and loading registers, memory maps, updating lists, etc.

### 2) Thread-based Multitasking (Multithreading)

    Threads share the same address space.

    A thread is lightweight.

    Cost of communication between the thread is low.

Note: At least one process is required for each thread.

### What is Thread in java

A thread is a lightweight subprocess, the smallest unit of processing. It is a separate path of execution.

Threads are independent. If there occurs exception in one thread, it doesn't affect other threads. It uses a shared memory area. 

A thread is executed inside the process. There is context-switching between the threads. There can be multiple processes inside the OS, and one process can have multiple threads. 

Note: At a time one thread is executed only.

### Java Thread class

Java provides Thread class to achieve thread programming. Thread class provides constructors and methods to create and perform operations on a thread. Thread class extends Object class and implements Runnable interface.

### Java Thread Methods
|   S.N. 	|   Modifier and Type 	|   Method 	|   Description |
| ------------- | ------------- | ------------- | ------------- |
|   1) 	|   void 	|   start() 	|   It is used to start the execution of the thread.    |
|   2) 	|   void 	|   run() 	|   It is used to do an action for a thread.    |
|   3) 	|   static void 	|   sleep() 	|   It sleeps a thread for the specified amount of time.    |
|   4) 	|   static Thread 	|   currentThread() 	|   It returns a reference to the currently executing thread object.    |
|   5) 	|   void 	|   join() 	|   It waits for a thread to die.   |
|   6) 	|   int 	|   getPriority() 	|   It returns the priority of the thread.  |
|   7) 	|   void 	|   setPriority() 	|   It changes the priority of the thread.  |
|   8) 	|   String 	|   getName() 	|   It returns the name of the thread.  |
|   9) 	|   void 	|   setName() 	|   It changes the name of the thread.  |
|   10) 	|   long 	|   getId() 	|   It returns the id of the thread.    |
|   11) 	|   boolean 	|   isAlive() 	|   It tests if the thread is alive.    |
|   12) 	|   static void 	|   yield() 	|   It causes the currently executing thread object to pause and allow other threads to execute temporarily.    |
|   13) 	|   void 	|   suspend()    	|   It is used to suspend the thread.   |
|   14) 	|   void 	|   resume() 	|   It is used to resume the suspended thread.  |
|   15) 	|   void 	|   stop() 	|   It is used to stop the thread.  |
|   16) 	|   void 	|   destroy() 	|   It is used to destroy the thread group and all of its subgroups.    |
|   17) 	|   boolean 	|   isDaemon() 	|   It tests if the thread is a daemon thread.  |
|   18) 	|   void 	|   setDaemon() 	|   It marks the thread as daemon or user thread.   |
|   19) 	|   void 	|   interrupt() 	|   It interrupts the thread.   |
|   20) 	|   boolean 	|   isinterrupted() 	|   It tests whether the thread has been interrupted.   |
|   21) 	|   static boolean 	|   interrupted() 	|   It tests whether the current thread has been interrupted.   |
|   22) 	|   static int 	|   activeCount() 	|   It returns the number of active threads in the current thread's thread group.   |
|   23) 	|   void 	|   checkAccess() 	|   It determines if the currently running thread has permission to modify the thread.  |
|   24) 	|   static boolean 	|   holdLock() 	|   It returns true if and only if the current thread holds the monitor lock on the specified object.   |
|   25) 	|   static void 	|   dumpStack() 	|   It is used to print a stack trace of the current thread to the standard error stream.   |
|   26) 	|   StackTraceElement[] 	|   getStackTrace() 	|   It returns an array of stack trace elements representing the stack dump of the thread.  |
|   27) 	|   static int 	|   enumerate() 	|   It is used to copy every active thread's thread group and its subgroup into the specified array.    |
|   28) 	|   Thread.State 	|   getState() 	|   It is used to return the state of the thread.   |
|   29) 	|   ThreadGroup 	|   getThreadGroup() 	|   It is used to return the thread group to which this thread belongs  |
|   30) 	|   String 	|   toString() 	|   It is used to return a string representation of this thread, including the thread's name, priority, and thread group.   |
|   31) 	|   void 	|   notify() 	|   It is used to give the notification for only one thread which is waiting for a particular object.   |
|   32) 	|   void 	|   notifyAll() 	|   It is used to give the notification to all waiting threads of a particular object.  |
|   33) 	|   void 	|   setContextClassLoader() 	|   It sets the context ClassLoader for the Thread. |
|   34) 	|   ClassLoader 	|   getContextClassLoader() 	|   It returns the context ClassLoader for the thread.  |
|   35) 	|   static Thread.UncaughtExceptionHandler 	|   getDefaultUncaughtExceptionHandler() 	|   It returns the default handler invoked when a thread abruptly terminates due to an uncaught exception.  |
|   36) 	|   static void 	|   setDefaultUncaughtExceptionHandler() 	|   It sets the default handler invoked when a thread abruptly terminates due to an uncaught exception.     |


## Life cycle of a Thread (Thread States)

A thread can be in one of the five states. According to sun, there is only 4 states in thread life cycle in java new, runnable, non-runnable and terminated. There is no running state.

But for better understanding the threads, we are explaining it in the 5 states.

The life cycle of the thread in java is controlled by JVM. The java thread states are as follows:

1.    New
2.    Runnable
3.    Running
4.    Non-Runnable (Blocked)
5.    Terminated



![Thread status](thread.png?raw=true "Thread status")



### 1) New

The thread is in new state if you create an instance of Thread class but before the invocation of start() method. 

### 2) Runnable

The thread is in runnable state after invocation of start() method, but the thread scheduler has not selected it to be the running thread. 

### 3) Running

The thread is in running state if the thread scheduler has selected it. 

### 4) Non-Runnable (Blocked)

This is the state when the thread is still alive, but is currently not eligible to run. 

### 5) Terminated

A thread is in terminated or dead state when its run() method exits. 


## How to create thread

There are two ways to create a thread:

1.    By extending Thread class
2.    By implementing Runnable interface.


### Thread class:
Thread class provide constructors and methods to create and perform operations on a thread.Thread class extends Object class and implements Runnable interface. 

Commonly used Constructors of Thread class:

    Thread()
    
    Thread(String name)

    Thread(Runnable r)

    Thread(Runnable r,String name)

### Commonly used methods of Thread class:

    public void run(): is used to perform action for a thread.
    
    public void start(): starts the execution of the thread.JVM calls the run() method on the thread.
    
    public void sleep(long miliseconds): Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
    
    public void join(): waits for a thread to die.
    
    public void join(long miliseconds): waits for a thread to die for the specified miliseconds.
    
    public int getPriority(): returns the priority of the thread.
    
    public int setPriority(int priority): changes the priority of the thread.
    
    public String getName(): returns the name of the thread.
    
    public void setName(String name): changes the name of the thread.
    
    public Thread currentThread(): returns the reference of currently executing thread.
    
    public int getId(): returns the id of the thread.
    
    public Thread.State getState(): returns the state of the thread.
    
    public boolean isAlive(): tests if the thread is alive.
    
    public void yield(): causes the currently executing thread object to temporarily pause and allow other threads to execute.
    
    public void suspend(): is used to suspend the thread(depricated).
    
    public void resume(): is used to resume the suspended thread(depricated).
    
    public void stop(): is used to stop the thread(depricated).
    
    public boolean isDaemon(): tests if the thread is a daemon thread.
    
    public void setDaemon(boolean b): marks the thread as daemon or user thread.
    
    public void interrupt(): interrupts the thread.
    
    public boolean isInterrupted(): tests if the thread has been interrupted.
    
    public static boolean interrupted(): tests if the current thread has been interrupted.


### Runnable interface:
The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread. Runnable interface have only one method named run().

    public void run(): is used to perform action for a thread.

### Starting a thread:
start() method of Thread class is used to start a newly created thread. It performs following tasks:

    A new thread starts(with new callstack).

    The thread moves from New state to the Runnable state.

    When the thread gets a chance to execute, its target run() method will run.

### 1) Java Thread Example by extending Thread class

```
    class Multi extends Thread{  
    public void run(){  
    System.out.println("thread is running...");  
    }  
    public static void main(String args[]){  
    Multi t1=new Multi();  
    t1.start();  
     }  
    }  
```

output: thread is running

### 2) Java Thread Example by implementing Runnable interface

```
    class Multi3 implements Runnable{  
    public void run(){  
    System.out.println("thread is running...");  
    }  
      
    public static void main(String args[]){  
    Multi3 m1=new Multi3();  
    Thread t1 =new Thread(m1);  
    t1.start();  
     }  
    }  
```

output: thread is running..

If you are not extending the Thread class,your class object would not be treated as a thread object.So you need to explicitely create Thread class object.We are passing the object of your class that implements Runnable so that your class run() method may execute.



## Thread Scheduler in Java

Thread scheduler in java is the part of the JVM that decides which thread should run.

There is no guarantee that which runnable thread will be chosen to run by the thread scheduler.

Only one thread at a time can run in a single process.

The thread scheduler mainly uses preemptive or time slicing scheduling to schedule the threads.


### Difference between preemptive scheduling and time slicing

Under preemptive scheduling, the highest priority task executes until it enters the waiting or dead states or a higher priority task comes into existence. Under time slicing, a task executes for a predefined slice of time and then reenters the pool of ready tasks. The scheduler then determines which task should execute next, based on priority and other factors. 

## Sleep method in java

The sleep() method of Thread class is used to sleep a thread for the specified amount of time.


### Syntax of sleep() method in java


The Thread class provides two methods for sleeping a thread:

    public static void sleep(long miliseconds)throws InterruptedException

    public static void sleep(long miliseconds, int nanos)throws InterruptedException

### Example of sleep method in java

```
    class TestSleepMethod1 extends Thread{  
     public void run(){  
      for(int i=1;i<5;i++){  
        try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
        System.out.println(i);  
      }  
     }  
     public static void main(String args[]){  
      TestSleepMethod1 t1=new TestSleepMethod1();  
      TestSleepMethod1 t2=new TestSleepMethod1();  
       
      t1.start();  
      t2.start();  
     }  
    }  


```

output :
       1
       1
       2
       2
       3
       3
       4
       4

As you know well that at a time only one thread is executed. If you sleep a thread for the specified time,the thread shedular picks up another thread and so on. 


## Can we start a thread twice

No. After starting a thread, it can never be started again. If you does so, an IllegalThreadStateException is thrown. In such case, thread will run once but for second time, it will throw exception.

Let's understand it by the example given below:

```
    public class TestThreadTwice1 extends Thread{  
     public void run(){  
       System.out.println("running...");  
     }  
     public static void main(String args[]){  
      TestThreadTwice1 t1=new TestThreadTwice1();  
      t1.start();  
      t1.start();  
     }  
    }  
```

output
running
       Exception in thread "main" java.lang.IllegalThreadStateException


## What if we call run() method directly instead start() method?


    Each thread starts in a separate call stack.

    Invoking the run() method from main thread, the run() method goes onto the current call stack rather than at the beginning of a new call stack.

```
    class TestCallRun1 extends Thread{  
     public void run(){  
       System.out.println("running...");  
     }  
     public static void main(String args[]){  
      TestCallRun1 t1=new TestCallRun1();  
      t1.run();//fine, but does not start a separate call stack  
     }  
    }  
```

output : running ...


Method will run in the main tread. It has not initiated another thread.

![call run() command](mainthread.png?raw=true "call run()")


### calling twice run method.

```
    class TestCallRun2 extends Thread{  
     public void run(){  
      for(int i=1;i<5;i++){  
        try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
        System.out.println(i);  
      }  
     }  
     public static void main(String args[]){  
      TestCallRun2 t1=new TestCallRun2();  
      TestCallRun2 t2=new TestCallRun2();  
       
      t1.run();  
      t2.run();  
     }  
    }  

```

output : 
Output:1
       2
       3
       4
       5
       1
       2
       3
       4
       5


As you can see in the above program that there is no context-switching because here t1 and t2 will be treated as normal object not thread object. 


## The join() method

The join() method waits for a thread to die. In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task.


    public void join()throws InterruptedException

    public void join(long milliseconds)throws InterruptedException


```
    class TestJoinMethod1 extends Thread{  
     public void run(){  
      for(int i=1;i<=5;i++){  
       try{  
        Thread.sleep(500);  
       }catch(Exception e){System.out.println(e);}  
      System.out.println(i);  
      }  
     }  
    public static void main(String args[]){  
     TestJoinMethod1 t1=new TestJoinMethod1();  
     TestJoinMethod1 t2=new TestJoinMethod1();  
     TestJoinMethod1 t3=new TestJoinMethod1();  
     t1.start();  
     try{  
      t1.join();  
     }catch(Exception e){System.out.println(e);}  
      
     t2.start();  
     t3.start();  
     }  
    }  

```


As you can see in the above example,when t1 completes its task then t2 and t3 starts executing.

Output:1
       2
       3
       4
       5
       1
       1
       2
       2
       3
       3
       4
       4
       5
       5

### Example of join(long miliseconds) method

```
    class TestJoinMethod2 extends Thread{  
     public void run(){  
      for(int i=1;i<=5;i++){  
       try{  
        Thread.sleep(500);  
       }catch(Exception e){System.out.println(e);}  
      System.out.println(i);  
      }  
     }  
    public static void main(String args[]){  
     TestJoinMethod2 t1=new TestJoinMethod2();  
     TestJoinMethod2 t2=new TestJoinMethod2();  
     TestJoinMethod2 t3=new TestJoinMethod2();  
     t1.start();  
     try{  
      t1.join(1500);  
     }catch(Exception e){System.out.println(e);}  
      
     t2.start();  
     t3.start();  
     }  
    }  

```

output
Output:1
       2
       3
       1
       4
       1
       2
       5
       2
       3
       3
       4
       4
       5
       5



In the above example,when t1 is completes its task for 1500 miliseconds(3 times) then t2 and t3 starts executing.

