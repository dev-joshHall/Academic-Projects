package hall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            ArrayList<ArrayList<ArrayList<String>>> tickerData = new ArrayList<ArrayList<ArrayList<String>>>();
            File tickerFile = new File("src/main/java/hall/Ticker.dat");
            Scanner reader = new Scanner(tickerFile);
            while (reader.hasNextLine()) {
                ArrayList<ArrayList<String>> dateData = new ArrayList<ArrayList<String>>();
                String data = reader.nextLine().trim();
                while (data.length() != 0) {
                    ArrayList<String> splitData = new ArrayList<>(Arrays.asList(data.split(" ", 0)));
                    dateData.add(splitData);
                    data = reader.nextLine().trim();
                }
                tickerData.add(dateData);
            }

            StockData sd = new StockData(tickerData);
            AverageDisplay avgDisplay = new AverageDisplay();
            sd.registerObserver(avgDisplay);
            SelectionsDisplay selDisplay = new SelectionsDisplay();
            sd.registerObserver(selDisplay);
            sd.notifyObservers();
            avgDisplay.displayOutput();
            selDisplay.displaySelected();

        } catch (FileNotFoundException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }
}
