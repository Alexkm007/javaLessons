package CreationalPatterns.builder.version1;

public class VisitCardWebSiteBuilder extends WebSiteBuilder{
    @Override
    void buildName() {
        website.setName("Visit card");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPREESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(500);
    }
}
