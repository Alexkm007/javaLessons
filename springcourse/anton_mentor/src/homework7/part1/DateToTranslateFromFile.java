package homework7.part1;

import java.io.BufferedReader;
import java.io.FileReader;

public class DateToTranslateFromFile implements DateToTranslateReturner{
    private String path = "";

    public DateToTranslateFromFile() {
    }

    public DateToTranslateFromFile(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String returnData() throws Exception {
        if(path == null || path.isEmpty()){
            throw new Exception("Не заполнен путь к файлу для перевода");
        }

        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()){
                sb.append(br.readLine()).append(System.lineSeparator());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
