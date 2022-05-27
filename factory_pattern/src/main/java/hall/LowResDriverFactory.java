package hall;

public class LowResDriverFactory extends DriverFactory {
    LowResDriverFactory(String command) {
        if (command.equals("w")) {
            createDisplayDriver();
        } else if (command.equals("d")) {
            createPrinterDriver();
        }
    }

    @Override
    void createDisplayDriver() {
        super.createDisplayDriver();
        LowResDisplayDriver lowResDisplayDriver = new LowResDisplayDriver();
        lowResDisplayDriver.display();
    }

    @Override
    void createPrinterDriver() {
        super.createPrinterDriver();
        LowResPrintDriver lowResPrintDriver = new LowResPrintDriver();
        lowResPrintDriver.print();
    }
}
