package com.example.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSrping {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
        AnnotationConfigApplicationContext context  =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
       /// Music rockMusic = context.getBean("rockMusic",RockMusic.class);
      //  Music classicalMusic = context.getBean("classicalMusic",ClassicalMusic.class);
        //MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);

        //System.out.println(rockMusic.getSong());
        //System.out.println(classicalMusic.getSong());
        //Music testBean = context.getBean("musicBean", Music.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
        Computer computer = context.getBean("computer",Computer.class);
        System.out.println(computer);
        context.close();
        //musicPlayer.playMusic();
    }
}
