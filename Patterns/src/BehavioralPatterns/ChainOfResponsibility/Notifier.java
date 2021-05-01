package BehavioralPatterns.ChainOfResponsibility;

public abstract class Notifier {
    private int priority;
    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String message,int level){
        if(priority <= level){
            write(message);
        }
        if(nextNotifier != null){
            nextNotifier.notifyManager(message,level);
        }

    }

    public abstract void write(String message);
}
