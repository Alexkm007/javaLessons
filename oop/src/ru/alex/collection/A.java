package ru.alex.collection;

import java.util.Objects;

public class A {
    private String name;
    private Integer age;

    public A(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return Objects.equals(getName(), a.getName()) && Objects.equals(getAge(), a.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
