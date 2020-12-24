package homework8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
    public static void saveToTxtOne(String path, TextContainer container){
        System.out.println("saveToTxtOne");
        save(path,container);
    }
    public static void saveToTxtTwo(String path, TextContainer container){
        System.out.println("saveToTxtTwo");
        save(path,container);
    }
    public static void saveToThree(String path,TextContainer container){
        System.out.println("saveToThree");
        save(path,container);
    }

    private static void save(String path,TextContainer container){
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
           bw.write(container.getText());
           bw.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
