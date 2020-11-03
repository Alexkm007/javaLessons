package com.company;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class MinMax {
    public static void main(String[] args) {

        List<Track> tracks = asList(new Track("Bakai",524),
                new Track("Violets",378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        System.out.println(shortestTrack);
        Track longestTrack = tracks.stream()
                .max(Comparator.comparing(track -> track.getLength()))
                .get();
        System.out.println(longestTrack);

        Integer x = asList(1,2,3,4,5,6).stream().max(Comparator.naturalOrder()).get();
        System.out.println(x);
    }
}
