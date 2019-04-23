/**
 * 
 Flying behavior implementation for ducks that do NOT fly
 (like rubber ducks and decoy ducks)
 */

 public class FlyNoWay implements FlyBehavior {
     public void fly(){
         System.out.println("I cant fly");
     }
 }