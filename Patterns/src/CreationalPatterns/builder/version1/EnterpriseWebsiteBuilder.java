package CreationalPatterns.builder.version1;

public class EnterpriseWebsiteBuilder extends WebSiteBuilder{
    @Override
    void buildName() {
        website.setName("Enterprise site");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.ALIFRESCO);
    }

    @Override
    void buildPrice() {
        website.setPrice(10000);
    }
}
