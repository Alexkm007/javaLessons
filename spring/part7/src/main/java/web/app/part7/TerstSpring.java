package web.app.part7;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TerstSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        System.out.println(musicPlayer.getGenreList().size());
        context.close();
    }
}
