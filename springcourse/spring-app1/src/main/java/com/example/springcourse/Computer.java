package com.example.springcourse;

import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    protected MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer " + id + " " + musicPlayer.playMusic();
    }
}
