package pl.zebek.springplayground.soundsystem;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";


    @PostConstruct
    public void postConstruct(){
        System.out.println("@POSTCONSTRUCT #################");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PREDESTROY #################");
    }
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
