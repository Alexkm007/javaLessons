package com.company;

public class Track {
    private int Length;
    private String name;

    public Track(String name,int length) {
        Length = length;
        this.name = name;
    }

    public int getLength() {
        return Length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Track{" +
                "Length=" + Length +
                ", name='" + name + '\'' +
                '}';
    }
}
