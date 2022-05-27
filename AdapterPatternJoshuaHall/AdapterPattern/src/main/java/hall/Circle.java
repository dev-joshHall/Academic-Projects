package hall;

public class Circle implements Shape {
    private XXCircle circle = new XXCircle();

    @Override
    public void setLocation() {
        circle.setLocation();
    }

    @Override
    public void getLocation() {
        circle.getLocation();
    }

    @Override
    public void display() {
        circle.displayIt();
    }

    @Override
    public void fill() {
        circle.fillIt();
    }

    @Override
    public void setColor() {
        circle.setItsColor();
    }

    @Override
    public void undisplay() {
        circle.undisplayIt();
    }
}
