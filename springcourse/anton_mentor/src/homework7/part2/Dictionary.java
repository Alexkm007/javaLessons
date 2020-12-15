package homework7.part2;

import homework7.part1.DictionaryReturner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private String path;
    private Map<String,String> dictionary = new HashMap<>();
    private String separatorWords = ":";
    private String separatorPair = ";";

    public Dictionary() {
    }

    public Dictionary(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void readDictionary() throws Exception {
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
                  String[] entry = pair.split(separatorWords);
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
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void addDataToDictionary() {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String lineEn = "";
        String lineRu = "";
        while (true) {

            try {
                System.out.println("Введите английское слово или Exit для выхода");
                lineEn = bf.readLine().trim();
                if(lineEn.toLowerCase().equals("exit")){
                    return;
                }
                System.out.println("Введите русский перевод слова " + lineEn);
                lineRu = bf.readLine().trim();
                dictionary.put(lineEn,lineRu);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void saveToFile(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry entry:dictionary.entrySet()){
            sb.append(entry.getKey()).append(separatorWords).append(entry.getValue()).append(separatorPair);
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
