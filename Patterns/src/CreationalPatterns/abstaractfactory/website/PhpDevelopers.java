package CreationalPatterns.abstaractfactory.website;

import CreationalPatterns.abstaractfactory.Developer;

public class PhpDevelopers implements Developer {
    @Override
    public void writeCode() {
        System.out.println("PhpDevelopers  writes php code...");
    }
}
