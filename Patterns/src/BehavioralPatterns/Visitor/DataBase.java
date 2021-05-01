package BehavioralPatterns.Visitor;

public class DataBase implements ProjectElement{
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}
