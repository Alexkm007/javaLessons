package web.app.part6;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TerstSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
        Computer computer = context.getBean("computer",Computer.class);
        System.out.println(computer.toString());

        PopMusic popMusic1 = context.getBean("popMusic",PopMusic.class);
        PopMusic popMusic2 = context.getBean("popMusic",PopMusic.class);
        System.out.println(popMusic1);
        System.out.println(popMusic2);

        context.close();
    }
}
