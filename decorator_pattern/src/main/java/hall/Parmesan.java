package hall;

public class Parmesan extends AddOnnDecorator {
    Pizza pizza;

    public Parmesan(Pizza pizza) { this.pizza = pizza; }

    public String getDescription() { return  pizza.getDescription() + ", Parmesan"; }

    public double cost() { return .10 + pizza.cost(); }
}
