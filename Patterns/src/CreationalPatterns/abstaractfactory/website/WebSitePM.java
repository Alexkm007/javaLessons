package CreationalPatterns.abstaractfactory.website;

import CreationalPatterns.abstaractfactory.ProjectManager;

public class WebSitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("WebSitePM manages website project...");
    }
}
