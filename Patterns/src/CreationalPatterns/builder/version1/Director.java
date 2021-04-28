package CreationalPatterns.builder.version1;

public class Director {
    private WebSiteBuilder builder;

    public void setBuilder(WebSiteBuilder builder) {
        this.builder = builder;
    }

    Website buildWebSite(){
       builder.createWebsite();
       builder.buildName();
       builder.buildCms();
       builder.buildPrice();
       return builder.getWebsite();
    }
}
