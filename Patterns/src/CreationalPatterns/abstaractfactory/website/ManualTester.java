package CreationalPatterns.abstaractfactory.website;

import CreationalPatterns.abstaractfactory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("ManualTester tests banking code...");
    }
}
