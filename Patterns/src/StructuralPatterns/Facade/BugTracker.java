package StructuralPatterns.Facade;

public class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint(){
        activeSprint = true;
        System.out.println("Sprint is active...");
    }

    public void finishSprint(){
        activeSprint = false;
        System.out.println("Sprint is not active...");
    }
}
