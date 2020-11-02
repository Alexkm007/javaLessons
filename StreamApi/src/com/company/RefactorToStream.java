package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class RefactorToStream {
    public static void main(String[] args) {

        Album album = new Album(asList(new Track("Bakai",524),
                new Track("Violets",378),
                new Track("Time Was", 451)));
        Album album1 = new Album(asList(new Track("Bakai1",360),
                new Track("Violets2",809),
                new Track("Time Was3", 45)));
        List<Album> albums = asList(album,album1);

    }
}
