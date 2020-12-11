package homework7;

import java.util.HashMap;
import java.util.Map;

public class DictionaryFromFile implements DictionaryReturner {

    private String path;
    private Map<String,String> dictionary = new HashMap<>();

    public DictionaryFromFile() {
    }

    public DictionaryFromFile(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Map returnDictionary() {

        return null;
    }


}
