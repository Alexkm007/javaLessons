package BehavioralPatterns.TemplateMethod;

public class WebSiteRunner {
    public static void main(String[] args) {
        WebSiteTemplate newsPage = new NewsPage();
        newsPage.showPage();

        System.out.println("========================");

        WebSiteTemplate welcomePage = new WelcomePage();
        welcomePage.showPage();
    }
}
