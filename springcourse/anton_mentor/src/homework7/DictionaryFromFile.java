package homework7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryFromFile implements DictionaryReturner {

    private String path;
    private Map<String,String> dictionary = new HashMap<>();
    private String separator = "=";

    public DictionaryFromFile() {
    }

    public DictionaryFromFile(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Map returnDictionary() throws Exception {

        if(path == null){
            throw new Exception("Не указан путь к файлу");
        }

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){

            while (bf.ready()){
              String[] entry =  bf.readLine().split(separator);
              if(entry.length < 2){
                  continue;
              }
              dictionary.put(entry[0],entry[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dictionary;
    }


}
