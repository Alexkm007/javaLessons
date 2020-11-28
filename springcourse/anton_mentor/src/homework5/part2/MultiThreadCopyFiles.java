package homework5.part2;

import java.io.*;
import java.nio.file.Paths;
import java.text.Format;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadCopyFiles {
    private String pathSource;
    private String pathDest;
    private volatile long progresByte = 0;
    private volatile byte[] buffer = new byte[1024];
    private ReentrantLock lock  = new ReentrantLock();
    private volatile boolean isFileRead = false;

    public MultiThreadCopyFiles() {
    }

    public MultiThreadCopyFiles(String pathSource, String pathDest) {
        this.pathSource = pathSource;
        this.pathDest = pathDest;
    }

    public String getPathSource() {
        return pathSource;
    }

    public void setPathSource(String pathSource) {
        this.pathSource = pathSource;
    }

    public String getPathDest() {
        return pathDest;
    }

    public void setPathDest(String pathDest) {
        this.pathDest = pathDest;
    }

    public void writeFile(){
        try (FileOutputStream os = new FileOutputStream(new File(pathDest))){
            while (!isFileRead){
            lock.lock();
            os.write(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printProgress(){

        long size  = new File(pathSource).length();
        while (!isFileRead){
            float proz = (float) (progresByte/size*100.00);
            String out = String.format("Выполнено -  %2.f! ",proz );
            try {
                System.out.write(out.getBytes());
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void readFile(){
        try (FileInputStream is = new FileInputStream(new File(pathSource))){
            while (is.read() != -1){
                lock.lock();
                if(is.available() < buffer.length){
                    buffer = new byte[is.available()];
                }
                progresByte = progresByte + buffer.length;
                is.read(buffer);
                lock.unlock();
            }
            buffer = new byte[0];
            isFileRead = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
