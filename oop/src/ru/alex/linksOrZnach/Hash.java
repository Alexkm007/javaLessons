package ru.alex.linksOrZnach;

import java.util.Objects;

public class Hash {
    private String name;
    private String email;
    private int age;
    private int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hash)) return false;
        Hash hash = (Hash) o;
        return age == hash.age && salary == hash.salary && name.equals(hash.name) && Objects.equals(email, hash.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, salary);
    }
}
