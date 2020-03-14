public class Leman extends CondimentDecorator {

    Beverage beverage;


    public Leman (Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription()+" Lemon Added ";
    }

    public double cost(){

        return beverage.cost() + 0.7;

    }



}