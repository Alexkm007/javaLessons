package com.company;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;


//Пример переделыки кода на стримы

public class RefactorToStream {
    public static void main(String[] args) {

        Album album = new Album(asList(new Track("Bakai", 524),
                new Track("Violets", 378),
                new Track("Time Was", 451)));
        Album album1 = new Album(asList(new Track("Bakai1", 360),
                new Track("Violets2", 809),
                new Track("Time Was3", 45)));
        List<Album> albums = asList(album, album1);
        System.out.println(trackNames(albums));
        System.out.println(trackNamesStream(albums));
    }

    private static Set<String> trackNames(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTracks())
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
        }
        return trackNames;
    }

    private static Set<String> trackNamesStream(List<Album> albums){
        return albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track->track.getLength()>60)
                .map(track->track.getName())
                .collect(toSet());
    }

}
