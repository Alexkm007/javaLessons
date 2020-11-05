package com.example.springcourse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MusicPlayer {
    private List<Music> musicList;
    private String name;
    private int volume;

    //IoC
    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer() {
        musicList = new ArrayList<>();
    }

    public void playMusic(){
        System.out.println("Playing: " + musicList.stream()
        .map(music->music.getSong())
        .collect(Collectors.toList()));
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}
