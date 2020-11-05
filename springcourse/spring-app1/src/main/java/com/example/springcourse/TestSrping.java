package com.example.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSrping {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Music classicalMusic = context.getBean("ClassicMusicBean",ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());
        //Music testBean = context.getBean("musicBean", Music.class);
//        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
//        musicPlayer.playMusic();
//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());
        context.close();

    }
}
