package BehavioralPatterns.Iterator;

public class DeveloperRunner {
    public static void main(String[] args) {
        String[] skills = {"Java","Spring","Hibernate", "Maven", "PostgreSql"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("Alex",skills);

        Iterator iterator = javaDeveloper.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
