package CreationalPatterns.abstaractfactory.website;

import CreationalPatterns.abstaractfactory.Developer;
import CreationalPatterns.abstaractfactory.ProjectManager;
import CreationalPatterns.abstaractfactory.ProjectTeamFactory;
import CreationalPatterns.abstaractfactory.Tester;

public class WebSiteFactory implements ProjectTeamFactory {
    @Override
    public Developer createDeveloper() {
        return new PhpDevelopers();
    }

    @Override
    public Tester createTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager createProjectTeamManager() {
        return new WebSitePM();
    }
}
