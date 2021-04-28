package CreationalPatterns.builder.version2;

public class Main {
    public static void main(String[] args) {

        Person alex = new PersonBuilder().setAge(38).setName("Alex").setSalary(2000000D).build();
        System.out.println(alex);

    }
}
