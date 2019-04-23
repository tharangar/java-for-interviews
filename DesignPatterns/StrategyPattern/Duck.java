public abstract class Duck {
    
   /**
    * 
    Declare two refernce variables for the 
    behavior interface types.
    All dick subclasses (in the same package)
    inherit these
    */ 
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    public Duck(){

    }

    // sub classes must override the method
    public abstract void display();

    // Delegate to the behavior class.
    public void performFly(){
        flyBehavior.fly();
    }

    // Delegate to the behavior class.
    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All duucks float");
    }
}