package ru.alex.clone;

public class A implements Cloneable {
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    protected A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }

    @Override
    public String toString() {
        return "A{" +
                "field='" + field + '\'' +
                '}';
    }
}
