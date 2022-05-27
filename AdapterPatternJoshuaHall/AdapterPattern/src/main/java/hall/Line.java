package hall;

public class Line implements Shape {
    @Override
    public void setLocation() {
        System.out.println("Setting line location...");
    }

    @Override
    public void getLocation() {
        System.out.println("Getting line location...");
    }

    @Override
    public void display() {
        System.out.println("Displaying line...");
    }

    @Override
    public void fill() {
        System.out.println("Filling line...");
    }

    @Override
    public void setColor() {
        System.out.println("Setting line color...");
    }

    @Override
    public void undisplay() {
        System.out.println("Undisplaying line...");
    }
}