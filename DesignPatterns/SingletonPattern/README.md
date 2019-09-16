## Singleton Pattern

If we want a class to have only one object, then we use the singleton patten. Such global one object is requied to connect with databases, logger and printers etc. Becouse if there are multiple objects we may encounter problems like incorrect program behaviour, inconsistent results etc.


Lets Use Singleton patter for creating a logger


```
public class Logger {

    // this logger can be accessed only from this class 
    private static Logger logger;

    public Logger(){


    } 


    // This method allow to access the private varible from outside.
    public static Logger getInstance(){

        if(logger == null){
            logger = new Logger();
        }

        return logger;

    }



}


```


Now create a TestLogger class



```
public class TestLogger {


    public static void main(String[] args){

        Logger obj1 =  Logger.getInstance();
        Logger obj2 = Logger.getInstance();
        // Prove that both object has same hashcode
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());


        // Prove that non singleton objects has different hascodes
        TestLogger obj3 = new TestLogger();
        TestLogger obj4 = new TestLogger();
        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());


    }


}

```