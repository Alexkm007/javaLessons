package homework5.part2;

import java.io.*;
import java.nio.file.Paths;
import java.text.Format;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadCopyFiles {
    private String pathSource;
    private String pathDest;
    private long progresByte = 0;
    private ReentrantLock lock = new ReentrantLock();
    private volatile byte[] buffer = new byte[100];
    private volatile boolean isFileRead = false;
    private volatile boolean bufferIsWrited = false;

    public MultiThreadCopyFiles() {
    }

    public void CopyFile() {

        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                readFile();
            }
        });

        Thread write = new Thread(new Runnable() {
            @Override
            public void run() {
                writeFile();
            }
        });

        Thread progress = new Thread(new Runnable() {
            @Override
            public void run() {
                printProgress();
            }
        });
        read.start();
        write.start();
        progress.start();
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

    public void writeFile() {
        try (FileOutputStream os = new FileOutputStream(new File(pathDest))) {
            while (!isFileRead) {
                while (!bufferIsWrited){
                    Thread.sleep(1);
                }
                lock.lock();
                if(!isFileRead){
                os.write(buffer);
                os.flush();
                bufferIsWrited = false;}
                lock.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printProgress() {

        long size = new File(pathSource).length();
        float proc = 0.0F;
        while (!isFileRead) {
            proc = (progresByte * 1.0F / size * 100.00F);
            String out = String.format("\r Выполнено -  %.2f%%! всего прочитанно %d byte", proc, progresByte);
            try {
                System.out.write(out.getBytes());
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        proc = 100.00F;
        String out = String.format("\r Выполнено -  %.2f%%! всего прочитанно %d byte", proc, progresByte);
        try {
            System.out.write(out.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try (FileInputStream is = new FileInputStream(new File(pathSource))) {
            while (is.available() != 0) {
                while (bufferIsWrited){
                    Thread.sleep(1);
                }
                lock.lock();
                if (is.available() < buffer.length) {
                    buffer = new byte[is.available()];
                }
                progresByte = progresByte + buffer.length;
                is.read(buffer);
                bufferIsWrited = true;
                lock.unlock();
            }
            while (bufferIsWrited){
                Thread.sleep(1);
            }
            lock.lock();
            buffer = new byte[0];
            isFileRead = true;
            bufferIsWrited = true;
            lock.unlock();
        } catch (Exception e) {
            isFileRead = true;
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

    }

}
