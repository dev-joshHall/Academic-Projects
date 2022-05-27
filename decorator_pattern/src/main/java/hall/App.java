package hall;

import java.util.Scanner;
import java.util.ArrayList;


public class App 
{
    public static void main( String[] args )
    {
        Pizza pizza;
        ArrayList<String> chosenItems = new ArrayList<String>();
        System.out.println("Welcome to the pizza shop!\nSelect Crust");
        System.out.println("\t- Thin: $1\n\t- Traditional: $2\n\t- Stuffed: $3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice: ");
        String choice = scanner.nextLine();
        if (isNumeric(choice)) {
            switch (choice.trim()) {
                case "1":
                    chosenItems.add("Thin Crust");
                    pizza = new ThinCrust();
                    break;
                case "2":
                    chosenItems.add("Traditional Crust");
                    pizza = new TraditionalCrust();
                    break;
                case "3":
                    chosenItems.add("Stuffed Crust");
                    pizza = new StuffedCrust();
                    break;
                default:
                    System.out.println("Invalid choice. Choose an option 1-3. Try Again.");
                    pizza = new TraditionalCrust();
                    System.exit(0);
            }
        } else {
            System.out.println("Invalid choice. Enter a number. Try Again.");
            pizza = new TraditionalCrust();
            System.exit(0);
        }
        System.out.println(pizza.getDescription());

        System.out.println("What kind of cheese?");
        System.out.println("\t- Mozzarella: $0.10\n\t- Parmesan: $0.10\n\t- Ricotta: $0.12\n\t- None");
        System.out.println("Choice: ");
        choice = scanner.nextLine();
        if (isNumeric(choice)) {
            switch (choice.trim()) {
                case "1":
                    chosenItems.add("Mozzarella");
                    pizza = new Mozzarella(pizza);
                    break;
                case "2":
                    chosenItems.add("Parmesan");
                    pizza = new Parmesan(pizza);
                    break;
                case "3":
                    chosenItems.add("Ricotta");
                    pizza = new Ricotta(pizza);
                    break;
                default:
                    System.out.println("No Cheese");
                    break;
            }
        } else {
            System.out.println("Invalid choice. Enter a number. Try Again.");
            System.exit(0);
        }
        System.out.println(pizza.getDescription());
        if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
            System.out.println("Another cheese?");
            System.out.println("\t- Mozzarella: $0.10\n\t- Parmesan: $0.10\n\t- Ricotta: $0.12\n\t- None");
            System.out.println("Choice: ");
            choice = scanner.nextLine();
            if (isNumeric(choice)) {
                switch (choice.trim()) {
                    case "1":
                        chosenItems.add("Mozzarella");
                        pizza = new Mozzarella(pizza);
                        break;
                    case "2":
                        chosenItems.add("Parmesan");
                        pizza = new Parmesan(pizza);
                        break;
                    case "3":
                        chosenItems.add("Ricotta");
                        pizza = new Ricotta(pizza);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Enter a number. Try Again.");
                System.exit(0);
            }
            System.out.println(pizza.getDescription());
        }

        System.out.println("Pick your toppings:");
        System.out.println("\t- Pepperoni: $0.50\n\t- Pineapple: $0.30\n\t- Chicken: $0.60\n\t- Done");
        System.out.println("Choice: ");
        choice = scanner.nextLine();
        if (isNumeric(choice)) {
            switch (choice.trim()) {
                case "1":
                    chosenItems.add("Pepperoni");
                    pizza = new Pepperoni(pizza);
                    break;
                case "2":
                    chosenItems.add("Pineapple");
                    pizza = new Pineapple(pizza);
                    break;
                case "3":
                    chosenItems.add("Chicken");
                    pizza = new Chicken(pizza);
                    break;
                default:
                    System.out.println("No Toppings");
                    break;
            }
        } else {
            System.out.println("Invalid choice. Enter a number. Try Again.");
            System.exit(0);
        }
        for (int i = 0; i < chosenItems.size(); i++) {
            System.out.print(chosenItems.get(i));
            if (i != chosenItems.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ");
        boolean wantsMore = choice.equals("1") || choice.equals("2") || choice.equals("3");
        while (wantsMore) {
            System.out.println("Pick your toppings:");
            System.out.println("\t- Pepperoni: $0.50\n\t- Pineapple: $0.30\n\t- Chicken: $0.60\n\t- Done");
            System.out.println("Choice: ");
            choice = scanner.nextLine();
            if (isNumeric(choice)) {
                switch (choice.trim()) {
                    case "1":
                        chosenItems.add("Pepperoni");
                        pizza = new Pepperoni(pizza);
                        break;
                    case "2":
                        chosenItems.add("Pineapple");
                        pizza = new Pineapple(pizza);
                        break;
                    case "3":
                        chosenItems.add("Chicken");
                        pizza = new Chicken(pizza);
                        break;
                    default:
                        wantsMore = false;
                        break;
                }
            } else {
                System.out.println("Invalid choice. Enter a number. Try Again.");
                System.exit(0);
            }
            if (wantsMore) {
                System.out.println(pizza.getDescription());
            }
        }

        System.out.println("\nYour Pizza:");
        System.out.print(pizza.getDescription());
        System.out.print(" - $");
        System.out.printf("%.2f", pizza.cost());
        System.out.println("\nHave a nice day!");
    }

    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
