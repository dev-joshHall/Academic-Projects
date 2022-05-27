package hall;

public class Pepperoni extends AddOnnDecorator {
    Pizza pizza;

    public Pepperoni(Pizza pizza) { this.pizza = pizza; }

    public String getDescription() { return  pizza.getDescription() + ", Pepperoni"; }

    public double cost() { return .50 + pizza.cost(); }
}
