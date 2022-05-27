package hall;

public class TraditionalCrust extends Pizza {
    public TraditionalCrust() {
        description = "Traditional Crust";
    }
    @Override
    public double cost() { return 2.00; }
}
