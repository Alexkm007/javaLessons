package homework5.part2;

import java.io.*;

public class MultiThreadCopyFiles {
    private String pathSource;
    private String pathDest;
    private long progresByte = 0;
    private byte[] buffer = new byte[1024*1024];

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

    public void readFile(){
        try (FileInputStream is = new FileInputStream(new File(pathSource))){

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
