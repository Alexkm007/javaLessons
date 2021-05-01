package StructuralPatterns.Proxy;

public class ProxyImage implements Image{

    private String file;
    private RealImage realImage;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if(realImage == null){
        realImage = new RealImage(file);}
        realImage.display();
    }
}
