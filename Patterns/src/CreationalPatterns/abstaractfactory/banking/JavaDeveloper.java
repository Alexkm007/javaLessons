package CreationalPatterns.abstaractfactory.banking;

import CreationalPatterns.abstaractfactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code...");
    }
}
