package hall;

public class Pineapple extends AddOnnDecorator {
    Pizza pizza;

    public Pineapple(Pizza pizza) { this.pizza = pizza; }

    public String getDescription() { return  pizza.getDescription() + ", Pineapple"; }

    public double cost() { return .30 + pizza.cost(); }
}
