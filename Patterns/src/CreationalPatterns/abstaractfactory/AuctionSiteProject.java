package CreationalPatterns.abstaractfactory;

import CreationalPatterns.abstaractfactory.website.WebSiteFactory;

public class AuctionSiteProject {

    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebSiteFactory();
        Developer developer  = projectTeamFactory.createDeveloper();
        Tester tester = projectTeamFactory.createTester();
        ProjectManager projectManager = projectTeamFactory.createProjectTeamManager();

        System.out.println("Creating bank system...");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }

}
