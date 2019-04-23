
public class MallardDuck extends Duck{

    public MallardDuck(){
        /**
         A MallardDuck uses the Quack class to handle its quack, 
         so when performquack is called the responsibility fo rth quack
         is delegated to the Quack object and we get a real quack.
         */
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    /**
     * 
     Remember MallardDuck inherits the quackBehaviour and
     flyBehavior instance variables from class Duck. 
     */

    public void display(){
        System.out.println("I am Mallard duck");
    }

}