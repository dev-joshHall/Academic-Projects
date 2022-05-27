package hall;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.io.File;

public class AverageDisplay implements Observer {

    ArrayList<ArrayList<ArrayList<String>>> listData;
    ArrayList<ArrayList<String>> avgData;

    public AverageDisplay() {
        listData = new ArrayList<ArrayList<ArrayList<String>>>();
        avgData = new ArrayList<ArrayList<String>>();
    }

    private void findAvg() {
        for (ArrayList<ArrayList<String>> dateChunck : listData) {
            double dateAvg = 0.0;
            ArrayList<String> dateAvgData = new ArrayList<String>();
            String dateStr = "";
            for (String s : dateChunck.get(0)) {
                if (!s.contains("Last") && !s.contains("updated")) {
                    dateStr += s + " ";
                }
            }
            double dateTotal = 0.0;
            double dateItems = dateChunck.size() - 1;
            for (int j = 0; j < dateChunck.size(); j++) {
                ArrayList<String> lineData = dateChunck.get(j);
                if (dateChunck.get(j).size() > 9 && dateChunck.get(j).get(0).length() != 0 && j != 0) {
                    dateTotal += Double.parseDouble(lineData.get(lineData.size() - 7));
                }
                dateAvg = dateTotal / dateItems;
            }
            dateAvgData.add(dateStr);
            dateAvgData.add(Double.toString(dateAvg));
            avgData.add(dateAvgData);
        }
    }

    public void displayOutput() {
        findAvg();
        try {
            File newFile = new File("src/main/java/hall/Average.dat");
            if (newFile.createNewFile()) {
                System.out.println("Results File created");
            }
            FileWriter writer = new FileWriter("src/main/java/hall/Average.dat");
            for (ArrayList<String> item : avgData) {
                writer.write(item.get(0));
                writer.write(", Average price: ");
                writer.write(item.get(1));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }

    public void update(ArrayList<ArrayList<ArrayList<String>>> updatedData) {
        listData = updatedData;
    }
}
