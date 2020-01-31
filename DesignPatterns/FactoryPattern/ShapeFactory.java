package DesignPatterns.FactoryPattern

public class ShapeFactory {

    // Use getShape mehtod to get object
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }

        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }  else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

         return null;

    }


}