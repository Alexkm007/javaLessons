package com.example.springcourse;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClassicalMusic implements Music{

    @PostConstruct
    public void doMyInit(){
        System.out.println("Выполняю инициализацию метода");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Выполняю подготовку к уничтожению бина");
    }


}
