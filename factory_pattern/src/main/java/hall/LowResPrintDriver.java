package hall;

public class LowResPrintDriver implements IPrintDriver{
    @Override
    public void print() {
        System.out.println("Printing a Document using LowResPrintDriver");
    }
}
