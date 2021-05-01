package BehavioralPatterns.Mediator;

public class SimpleChatRunner {
    public static void main(String[] args) {

        SimpleTextChat chat = new SimpleTextChat();

        User user1 = new SimpleUser(chat,"user1");
        User user2 = new SimpleUser(chat,"user2");

        User admin = new Admin(chat,"admin");
        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);

       // user1.sendMessage("Hi");
      //  user2.sendMessage("Hi");
        admin.sendMessage("Hi");
    }
}
