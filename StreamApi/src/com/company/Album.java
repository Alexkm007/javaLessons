package com.company;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private List<Track> tracks = new ArrayList<>();

    public Album(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
