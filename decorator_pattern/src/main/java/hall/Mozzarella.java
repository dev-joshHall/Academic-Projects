package hall;

public class Mozzarella extends AddOnnDecorator {
    Pizza pizza;

    public Mozzarella(Pizza pizza) { this.pizza = pizza; }

    public String getDescription() { return  pizza.getDescription() + ", Mozzarella"; }

    public double cost() { return .10 + pizza.cost(); }
}
