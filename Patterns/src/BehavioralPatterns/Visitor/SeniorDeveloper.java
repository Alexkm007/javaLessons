package BehavioralPatterns.Visitor;

public class SeniorDeveloper implements Developer {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewrite class...");
    }

    @Override
    public void create(DataBase dataBase) {
        System.out.println("Fixing data base...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating reliable test...");
    }
}
