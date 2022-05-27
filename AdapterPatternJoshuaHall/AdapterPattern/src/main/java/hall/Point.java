package hall;

public class Point implements Shape {
    @Override
    public void setLocation() {
        System.out.println("Setting point location...");
    }

    @Override
    public void getLocation() {
        System.out.println("Getting point location...");
    }

    @Override
    public void display() {
        System.out.println("Displaying point...");
    }

    @Override
    public void fill() {
        System.out.println("Filling point...");
    }

    @Override
    public void setColor() {
        System.out.println("Setting point color...");
    }

    @Override
    public void undisplay() {
        System.out.println("Undisplaying point...");
    }
}
