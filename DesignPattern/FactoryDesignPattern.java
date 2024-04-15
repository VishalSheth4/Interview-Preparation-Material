// --------- Factory Design Pattern (Creational)

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class ShapeFactory {
// Factory method to create Shape objects based on the given type
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Create a Circle
        Shape circle = shapeFactory.getShape("CIRCLE");
        // Call draw method of Circle
        circle.draw();

        // Create a Square
        Shape square = shapeFactory.getShape("SQUARE");
        // Call draw method of Square
        square.draw();
    }
}