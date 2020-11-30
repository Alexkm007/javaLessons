package homework5.part3;

public class Main {
    public static void main(String[] args) {
        MultiThreadSearchFile ms = new MultiThreadSearchFile();
        ms.setStartFolderSearch("/");
        ms.setNameToSearh("test.txt");
        ms.searchFile();
    }
}
