package homework7.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class DictionaryFromFile implements DictionaryReturner {

    private String path;
    private Map<String,String> dictionary = new HashMap<>();
    private String separatorWords = ":";
    private String separatorPair = ";";

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
            StringBuilder sb = new StringBuilder();
            while (bf.ready()){
                sb.append(bf.readLine().trim());
            }
            String[] pairWords = sb.toString().split(separatorPair);
              for(String pair:pairWords){
                  String[] entry = pair.split(":");
                  if(entry.length == 0){
                      continue;
                  }else if(entry.length == 1){
                      dictionary.put(entry[0].trim().toLowerCase(),"");
                      continue;
                  }
                  dictionary.put(entry[0].trim().toLowerCase(),entry[1].trim());
              }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dictionary;
    }


}
