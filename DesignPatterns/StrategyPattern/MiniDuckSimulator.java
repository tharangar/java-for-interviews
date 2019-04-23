
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
    }
}