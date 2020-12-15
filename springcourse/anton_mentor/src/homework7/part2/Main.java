package homework7.part2;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.setPath("/home/aleksei/test/dictionary/dictionary.txt");
        try {
            dictionary.readDictionary();
            dictionary.addDataToDictionary();
            dictionary.saveToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
