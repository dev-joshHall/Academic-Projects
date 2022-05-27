package hall;

public class Chicken extends AddOnnDecorator{
    Pizza pizza;

    public Chicken(Pizza pizza) { this.pizza = pizza; }

    public String getDescription() { return  pizza.getDescription() + ", Chicken"; }

    public double cost() { return .60 + pizza.cost(); }
}
