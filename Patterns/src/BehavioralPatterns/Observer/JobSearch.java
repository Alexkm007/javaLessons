package BehavioralPatterns.Observer;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();
        jobSite.addVacancy("First Java position");
        jobSite.addVacancy("Second Java position");

        Subscriber subscriber1 = new Subscriber("Alex");
        Subscriber subscriber2 = new Subscriber("Petia");

        jobSite.addObserver(subscriber1);
        jobSite.addObserver(subscriber2);

        jobSite.addVacancy("Third Java potion");
        jobSite.removeVacancy("First Java position");
    }
}
