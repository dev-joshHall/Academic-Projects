package hall;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SelectionsDisplay implements Observer {
    ArrayList<ArrayList<ArrayList<String>>> listData;
    ArrayList<ArrayList<String>> selectedData;


    public SelectionsDisplay() {
        listData = new ArrayList<ArrayList<ArrayList<String>>>();
        selectedData = new ArrayList<ArrayList<String>>();
    }

    private void selectData() {
        for (int i = 0; i < listData.size(); i++) {
            ArrayList<String> outputArr = new ArrayList<String>();
            ArrayList<ArrayList<String>> dateChunk = listData.get(i);
            String dateStr = "";
            for (String s : dateChunk.get(0)) {
                if (!s.contains("Last") && !s.contains("updated")) {
                    dateStr += s + " ";
                }
            }
            outputArr.add(dateStr);
            for (int j = 0; j < listData.get(i).size(); j++) {
                if (j == 3) {
                    String selectedStr = "";
                    for ( String s : listData.get(i).get(j)) {
                        selectedStr += s + " ";
                    }
                    outputArr.add(selectedStr);
                }
            }
            selectedData.add(outputArr);
        }
    }

    public void displaySelected() {
        selectData();
        try {
            File newFile = new File("src/main/java/hall/Selections.dat");
            if (newFile.createNewFile()) {
                System.out.println("Results File created");
            }
            FileWriter writer = new FileWriter("src/main/java/hall/Selections.dat");
            for (ArrayList<String> item : selectedData) {
                writer.write(item.get(0));
                writer.write(", ");
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
