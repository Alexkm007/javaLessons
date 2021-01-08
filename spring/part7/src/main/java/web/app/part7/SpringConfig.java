package web.app.part7;

import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("web.app.part7")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {


    //    @Bean
//    public ClassicalMusic classicalMusic(){
//        return new ClassicalMusic();}
//    @Bean
//    public PopMusic popMusic(){
//        return new PopMusic();}
//    @Bean
//    public RockMusic rockMusic(){
//        return new RockMusic();}
//    @Bean
//    public MusicPlayer musicPlayer(){
//        return new MusicPlayer();
//    }
//    @Bean
//    public Computer computer(){
//        return new Computer(new MusicPlayer());
//    }



}
