package homework7.part1;

public class Main {
    public static void main(String[] args) {
        DictionaryFromFile dr = new DictionaryFromFile();
        dr.setPath("/home/aleksei/test/dictionary/dictionary.txt");
        DateToTranslateFromFile dt = new DateToTranslateFromFile("/home/aleksei/test/dictionary/English.in");
        Translator translator = new Translator(dr,dt,"/home/aleksei/test/dictionary/Rus.out");
        translator.transleitText();
    }
}
