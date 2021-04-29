package StructuralPatterns.bridge;

public class BankSystem extends Program{
    protected BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Start making BankSystem program....");
        developer.writeCode();
    }
}
