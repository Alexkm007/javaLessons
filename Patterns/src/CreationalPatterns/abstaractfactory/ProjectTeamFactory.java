package CreationalPatterns.abstaractfactory;

public interface ProjectTeamFactory {
    Developer createDeveloper();
    Tester createTester();
    ProjectManager createProjectTeamManager();
}
