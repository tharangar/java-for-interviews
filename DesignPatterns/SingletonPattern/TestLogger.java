//package singleton;


public class TestLogger{
    public static void main(String[] args){

        Logger obj1 = Logger.getInstance();
        Logger obj2 = Logger.getInstance();
        
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

    }



}