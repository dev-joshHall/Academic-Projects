package hall;

import java.util.ArrayList;

/**
 * Skeleton code to illustrate the Adapter Pattern for the scenario problem given
 * where we need to write a Circle class but someone has already written one that
 * we can use.
 * Author: Joshua Hall (10787004)
 * Last updated: 3/18/2022
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Creating shape objects...\n" );
        Point point = new Point();
        Line line = new Line();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(point);
        shapes.add(line);
        shapes.add(rectangle);
        shapes.add(circle);

        for (Shape shape : shapes) {
            shape.setLocation();
            shape.getLocation();
            shape.display();
            shape.undisplay();
            shape.fill();
            shape.setColor();
            System.out.println("");
        }
    }
}
