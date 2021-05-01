package StructuralPatterns.Proxy;

public class ProxyApp {
    public static void main(String[] args) {

        Image image = new ProxyImage("/image.jpg");
        image.display();

    }
}
