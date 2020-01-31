package DesignPatterns.FactoryPattern

public class FactoryPatternDemo{

    public static void main(String[] args){

        ShapeFactory shapeFactory = new ShapeFactory();

        // get an object of Circle and call its draw method
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        // call drow mehtoe.
        shape1.draw();

        // get an object of Rectangel and call it's drow method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        // get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();



    }


}