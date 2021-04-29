package StructuralPatterns.bridge;

public class StockExchange extends Program{

    public StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Start making StockExchange program....");
        developer.writeCode();
    }
}
