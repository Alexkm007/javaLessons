package homework7;

public class Translator {

    private DictionaryReturner dictionary;
    private DateToTranslateReturner textSource;

    public Translator() {
    }

    public Translator(DictionaryReturner dictionary, DateToTranslateReturner textSource) {
        this.dictionary = dictionary;
        this.textSource = textSource;
    }

    public void setDictionary(DictionaryReturner dictionary) {
        this.dictionary = dictionary;
    }

    public void setTextSource(DateToTranslateReturner textSource) {
        this.textSource = textSource;
    }

    public void transleitText(){
        try {
            String[] words = textSource.returnData().split(" ");
            StringBuilder sb = new StringBuilder();

            for(String word:words){



            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

