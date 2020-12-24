package homework3;

import test.B;

import java.io.*;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToFilesInOne {

    public static void mergingFiles (String file1, String file2, String FileRezult) {

        try (FileInputStream is1 = new FileInputStream(file1);
            FileInputStream is2 = new FileInputStream(file2);
            FileOutputStream os = new FileOutputStream(FileRezult);
        ){

            byte[] bytes = new byte[is1.available()];
            byte[] bytes2 = new byte[is2.available()];

            is1.read(bytes);
            is2.read(bytes2);

            String data1 = new String(bytes);
            String data2 = new String(bytes2);

            StringBuilder sb = new StringBuilder();

            Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                            | Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(data2);

            while (matcher.find()){
                String word = matcher.group();
                pattern = Pattern.compile(String.format("(?i).*?\\b%s\\b.*?", word), Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);
                Matcher matcher2 = pattern.matcher(data1);
                if(matcher2.find()){
                    sb.append(word).append(" ");
                }
            }

            os.write(sb.toString().trim().getBytes());
            os.flush();
            System.out.println("Выполнено!!!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String file1 = "C:\\test\\in1.txt";
        String file2 = "C:\\test\\in2.txt";
        String out = "C:\\test\\out.txt";
        mergingFiles(file1,file2,out);
    }

}
