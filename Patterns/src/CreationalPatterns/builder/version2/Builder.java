package CreationalPatterns.builder.version2;

public interface Builder {
    Builder setName(String name);
    Builder setAge(int age);
    Builder setSalary(double salary);
    Person build();
}
