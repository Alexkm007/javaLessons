package CreationalPatterns.abstaractfactory.banking;

import CreationalPatterns.abstaractfactory.Developer;
import CreationalPatterns.abstaractfactory.ProjectManager;
import CreationalPatterns.abstaractfactory.ProjectTeamFactory;
import CreationalPatterns.abstaractfactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester createTester() {
        return new QATester();
    }

    @Override
    public ProjectManager createProjectTeamManager() {
        return new BankingPM();
    }
}
