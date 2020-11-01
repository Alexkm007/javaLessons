package com.company;

public class Artist implements FuncGetName{
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
