package BehavioralPatterns.Visitor;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();
        Developer junior = new JuniorDeveloper();
        SeniorDeveloper senior = new SeniorDeveloper();

        System.out.println("Junior is active");
        project.beWritten(junior);
        System.out.println("================");
        System.out.println("Senior is active");
        project.beWritten(senior);

    }
}
