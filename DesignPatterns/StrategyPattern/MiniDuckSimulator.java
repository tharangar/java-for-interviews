
public class MiniDuckSimulator {
    public static void main(String[] args){
        Duck mallard = new MallardDuck();
        /**
         Thsi calls the MallardDuck's inherited performeQuack()
         mehtod, which then delegates to the object's QuackBehavior (calls quck)
         on the duck's inherited quackBehaviour reference
         */
        mallard.performQuack();
        mallard.performFly();

 
        // Test the dynamic behavior allocation 
       
        Duck model = new ModelDuck();
        /**
         The first call to performeFly() delegates 
         to the flyBehavior object set in the ModelDuck's constructor, which is a
         FlyNoWay instance
         */
        model.performFly();

        /**
         This invokes the model's inherited behavior setter method, and
         voila ! 
         The model suddenly has rocket-powered flying capability.
         */

        model.setFlyBehavior(new FlyRocketPowered());

        model.performFly();

    }
}