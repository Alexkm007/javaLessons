package BehavioralPatterns.Command;

public class DeleteCommand implements Command{
    private DataBase dataBase;

    public DeleteCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.delete();
    }
}
