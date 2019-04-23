
public class ModelDuck extends Duck {

    public ModelDuck(){
        /**
         Our model duck begins life grounded
         without way to fly
         */
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I am a model duck");
    }
}