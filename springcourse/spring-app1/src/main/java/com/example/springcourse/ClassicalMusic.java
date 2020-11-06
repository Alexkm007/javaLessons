package com.example.springcourse;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music{

    public void doMyInit(){
        System.out.println("Выполняю инициализацию метода");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    public void doMyDestroy(){
        System.out.println("Выполняю подготовку к уничтожению бина");
    }
}
