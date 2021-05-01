package BehavioralPatterns.TemplateMethod;

public class NewsPage extends WebSiteTemplate{

    @Override
    public void showPageContent() {
        System.out.println("News");
    }
}
