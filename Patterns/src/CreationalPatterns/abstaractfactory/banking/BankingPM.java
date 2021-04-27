package CreationalPatterns.abstaractfactory.banking;

import CreationalPatterns.abstaractfactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("BankingPM manages banking project...");
    }
}
