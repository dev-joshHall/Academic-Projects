package hall;

public class HighResDriverFactory extends DriverFactory {
    HighResDriverFactory (String command) {
        if (command.equals("w")) {
            createDisplayDriver();
        } else if (command.equals("d")) {
            createPrinterDriver();
        }
    }

    @Override
    void createDisplayDriver() {
        super.createDisplayDriver();
        HighResDisplayDriver highResDisplayDriver = new HighResDisplayDriver();
        highResDisplayDriver.display();
    }

    @Override
    void createPrinterDriver() {
        super.createPrinterDriver();
        HighResPrintDriver highResPrintDriver = new HighResPrintDriver();
        highResPrintDriver.print();
    }
}
