package hall;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        DriverFactory factory;
        System.out.println("Do you have a low or high res driver? (l or h) ");
        Scanner scanner = new Scanner(System.in);
        String res_response = scanner.nextLine();
        res_response = res_response.toLowerCase();
        while (!res_response.equals("l") && !res_response.equals("h")) {
            System.out.println("Invalid input. Enter an 'l' or 'h' for low or high res driver: ");
            res_response = scanner.nextLine();
        }
        System.out.println("Type 'd' to print a document,\n'w' to draw a widget,\nor 'q' to quit: ");
        String command = scanner.nextLine();
        command = command.toLowerCase();
        while (!command.equals("d") && !command.equals("w") && !command.equals("q")) {
            System.out.println("Invalid input. Enter a 'd' (write doc), 'w' (make widget), or 'q' (quit): ");
            command = scanner.nextLine();
        }
        if (res_response.equals("h")) {
            while (!command.equals("q")) {
                factory = new HighResDriverFactory(command);
                System.out.println("\nType 'd' to print a document,\n'w' to draw a widget,\nor 'q' to quit: ");
                command = scanner.nextLine();
                command = command.toLowerCase();
                while (!command.equals("d") && !command.equals("w") && !command.equals("q")) {
                    System.out.println("Invalid input. Enter a 'd' (write doc), 'w' (make widget), or 'q' (quit): ");
                    command = scanner.nextLine();
                }
            }
        } else if (res_response.equals("l")) {
            while (!command.equals("q")) {
                factory = new LowResDriverFactory(command);
                System.out.println("\nType 'd' to print a document,\n'w' to draw a widget,\nor 'q' to quit: ");
                command = scanner.nextLine();
                command = command.toLowerCase();
                while (!command.equals("d") && !command.equals("w") && !command.equals("q")) {
                    System.out.println("Invalid input. Enter a 'd' (write doc), 'w' (make widget), or 'q' (quit): ");
                    command = scanner.nextLine();
                }
            }
        }
        System.out.println("Exiting...");
    }
}
