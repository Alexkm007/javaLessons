package web.app.part2;

public class MusicPlayer {
    private Music music;

    public MusicPlayer() {
    }
    // IoC
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic(){
        System.out.println("Playing: " + music.getSong());
    }

}
