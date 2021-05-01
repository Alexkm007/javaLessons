package StructuralPatterns.Proxy;

public class RealImage implements Image{

    private String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    void load(){
        System.out.println("Загружаю файл " + file + " ....");
    }

    @Override
    public void display() {
        System.out.println("Просмотр файла " + file);
    }
}
