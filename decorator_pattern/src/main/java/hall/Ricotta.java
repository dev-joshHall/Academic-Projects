package hall;

public class Ricotta extends AddOnnDecorator {
    Pizza pizza;

    public Ricotta(Pizza pizza) { this.pizza = pizza; }

    public String getDescription() { return  pizza.getDescription() + ", Ricotta"; }

    public double cost() { return .12 + pizza.cost(); }
}
