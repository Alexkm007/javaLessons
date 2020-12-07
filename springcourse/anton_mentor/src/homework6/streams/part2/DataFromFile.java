package homework6.streams.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFromFile implements DataProvider{
    private String path;
    private String data;

    public DataFromFile() {
    }

    public DataFromFile(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String readFile(){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(path))){
            while (bf.ready()){
                sb.append(bf.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return sb.toString();
    }

    private List<Float> searchNumbers(){
        List<Float> list = new ArrayList<>();
        Pattern pat=Pattern.compile("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)");
        Matcher matcher= pat.matcher(data);
        while (matcher.find()) {
            list.add(Float.parseFloat(matcher.group()));
        };
        return list;
    }

    @Override
    public List<Float> returnData() {
        data = readFile();
        return searchNumbers();
    }
}
