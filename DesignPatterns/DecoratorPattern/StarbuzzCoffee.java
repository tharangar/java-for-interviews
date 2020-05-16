public class StarbuzzCoffee {

    public static void main(String args[]){
        Beverage beverage = new Expresso();
        System.out.println(beverage.getDescription() + " $ " + beverage.cost()) ;

        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " $ " + beverage.cost()) ;

        beverage = new Leman(beverage);
        System.out.println(beverage.getDescription() + " $ " + beverage.cost()) ;

        // Add two condiments at once
        Beverage beverage2 = new Expresso();
        beverage2 = new Mocha( new Leman(beverage2));
        System.out.println("2nd one : "+beverage2.getDescription() + " $ " + beverage2.cost()) ;

        // adding double mocha
        Beverage beverage3 = new Expresso();
        beverage3 = new Mocha( new Mocha(beverage3));
        System.out.println("Double Mocha : "+beverage3.getDescription() + " $ " + beverage3.cost()) ;

    
    }

}