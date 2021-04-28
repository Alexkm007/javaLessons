package CreationalPatterns.builder.version1;

public class BuildWebSiteRunner {
    public static void main(String[] args) {

        Director director = new Director();

        director.setBuilder(new EnterpriseWebsiteBuilder());
        Website website = director.buildWebSite();
        System.out.println(website.toString());

        director.setBuilder(new VisitCardWebSiteBuilder());
        website = director.buildWebSite();
        System.out.println(website.toString());

    }
}
