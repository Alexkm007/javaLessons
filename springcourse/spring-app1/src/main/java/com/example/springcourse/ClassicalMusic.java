package com.example.springcourse;

public class ClassicalMusic implements Music{

    private ClassicalMusic() {
    }

    static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

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
