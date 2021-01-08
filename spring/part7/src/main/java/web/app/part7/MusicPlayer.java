package web.app.part7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import web.app.part7.musicsGenres.Genre;

import java.util.List;

@Component
public class MusicPlayer {

    @Autowired
    private List<Genre> genreList;
    private ClassicalMusic classicalMusic;
    @Autowired
    @Qualifier("popMusic")
    private Music music;
    private Music music1;
    private Music music2;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.value}")
    private int volume;


    public MusicPlayer() {
    }

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic")Music music1,@Qualifier("classicalMusic")Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String playMusic(){
        System.out.println("Playing: " + music.getSong());
        System.out.println("Playing: " + music1.getSong());
        return "Playing: " + music2.getSong();

    }

    public List<Genre> getGenreList() {
        return genreList;
    }
}
