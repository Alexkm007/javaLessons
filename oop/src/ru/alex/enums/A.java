package ru.alex.enums;

public enum A {
    D("V"),B("VK"),C("RR");
    private String a;
    private String d;

    A(String a) {
        this.a = a;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getA() {
        return a;
    }
}
