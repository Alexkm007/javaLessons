package CreationalPatterns.builder.version1;

public abstract class WebSiteBuilder {
    Website website;

    void createWebsite(){
        website = new Website();
    }

    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();

    Website getWebsite(){
        return website;
    }

}
