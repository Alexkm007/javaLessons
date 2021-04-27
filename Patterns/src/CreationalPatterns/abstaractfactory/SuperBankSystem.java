package CreationalPatterns.abstaractfactory;

import CreationalPatterns.abstaractfactory.banking.BankingTeamFactory;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer  = projectTeamFactory.createDeveloper();
        Tester tester = projectTeamFactory.createTester();
        ProjectManager projectManager = projectTeamFactory.createProjectTeamManager();

        System.out.println("Creating bank system...");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
