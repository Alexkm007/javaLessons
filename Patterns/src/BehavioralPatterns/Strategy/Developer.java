package BehavioralPatterns.Strategy;

public class Developer {
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void executeActivity(){
        this.activity.justDoIt();
    }
}
