package homework4.part3;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MultiThreadCopyFiles multiThreadCopyFiles = new MultiThreadCopyFiles();
        multiThreadCopyFiles.setPathSource("C:\\test");
        multiThreadCopyFiles.setPathDest("C:\\test\\copy");
        try {
            multiThreadCopyFiles.copyAllFiles(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}