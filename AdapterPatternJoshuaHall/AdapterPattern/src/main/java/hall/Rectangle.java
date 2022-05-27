package hall;

public class Rectangle implements Shape {
    @Override
    public void setLocation() {
        System.out.println("Setting rectangle location...");
    }

    @Override
    public void getLocation() {
        System.out.println("Getting rectangle location...");
    }

    @Override
    public void display() {
        System.out.println("Displaying rectangle...");
    }

    @Override
    public void fill() {
        System.out.println("Filling rectangle...");
    }

    @Override
    public void setColor() {
        System.out.println("Setting rectangle color...");
    }

    @Override
    public void undisplay() {
        System.out.println("Undisplaying rectangle...");
    }
}