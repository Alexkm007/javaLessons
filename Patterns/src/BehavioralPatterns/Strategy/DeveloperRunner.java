package BehavioralPatterns.Strategy;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRunner {
    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>();
        activities.add(new Coding());
        activities.add(new Reading());
        activities.add(new Training());
        activities.add(new Slipping());

        Developer developer = new Developer();

        for (Activity activity:activities){
            developer.setActivity(activity);
            developer.executeActivity();
        }

    }
}
