package BehavioralPatterns.TemplateMethod;

public class WelcomePage extends WebSiteTemplate{

    @Override
    public void showPageContent() {
        System.out.println("Welcome");
    }
}
