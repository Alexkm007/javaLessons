package BehavioralPatterns.Memento;

public class SaveProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();
        GitHubRepo gitHub = new GitHubRepo();

        System.out.println("Creating new project. Version 1.0");
        project.setVersionAndDate("Version 1.0");

        System.out.println(project);

        System.out.println("Saving current version to gitHub...");
        gitHub.setSave(project.save());

        System.out.println("Updating project to Version 1.1");
        project.setVersionAndDate("Version 1.1");

        System.out.println(project);

        System.out.println("Rolling back to version 1.0");
        project.load(gitHub.getSave());
        System.out.println(project);

    }
}
