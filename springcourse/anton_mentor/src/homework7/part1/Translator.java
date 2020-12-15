package homework7.part1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Translator {

    private DictionaryReturner dictionary;
    private DateToTranslateReturner textSource;
    private String pathToOut;

    public Translator() {
    }

    public Translator(DictionaryReturner dictionary,
                      DateToTranslateReturner textSource,
                      String pathToOut) {
        this.dictionary = dictionary;
        this.textSource = textSource;
        this.pathToOut  = pathToOut;
    }

    public void setPathToOut(String pathToOut) {
        this.pathToOut = pathToOut;
    }

    public void setDictionary(DictionaryReturner dictionary) {
        this.dictionary = dictionary;
    }

    public void setTextSource(DateToTranslateReturner textSource) {
        this.textSource = textSource;
    }

    private Word returnWordToTranslate(String word){
        Word wordTotranclate = new Word();
        if(word.contains("\n")){
            wordTotranclate.setPost("\n");
            word = word.replace("\n","");
        }

        char[] chars = word.substring(word.length()-1).toCharArray();
        if(!Character.isAlphabetic(chars[0])){
            wordTotranclate.setStr(word.substring(0,word.length()-1));
            wordTotranclate.setPost(new String(chars)  + wordTotranclate.getPost());
        }else wordTotranclate.setStr(word);

        return wordTotranclate;
    }

    public void transleitText(){
        StringBuilder sb = new StringBuilder();
        Word wordToTranslate;
        try {
            String[] words = textSource.returnData().split(" ");

            Map<String,String> mapDictionary = dictionary.returnDictionary();
            for(String word:words){
                if(word.length() == 0){
                    continue;
                }
                wordToTranslate = returnWordToTranslate(word.toLowerCase());
                String ruWord = mapDictionary.get(wordToTranslate.getStr());
                if(ruWord!=null){
                    sb.append(ruWord).append(wordToTranslate.getPost()).append(" ");
                }else sb.append(word).append(" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToOut))) {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class Word{
        private String str = "";
        private String post = "";

        public Word() {
        }

        public Word(String str, String post) {
            this.str = str;
            this.post = post;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }
    }

}

