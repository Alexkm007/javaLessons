package BehavioralPatterns.Mediator;

import java.util.ArrayList;
import java.util.List;

public class SimpleTextChat implements Chat{
    private User admin;
    private List<User> users = new ArrayList<>();

    public void addUserToChat(User user){
        this.users.add(user);
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u:users){
            if(u!=user){
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}
