package web.app.part6;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TerstSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
//        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
//        musicPlayer.playMusic();
        Computer computer = context.getBean("computer",Computer.class);
        System.out.println(computer.toString());
        context.close();
    }
}
