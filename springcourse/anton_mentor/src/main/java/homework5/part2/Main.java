package homework5.part2;

public class Main {
    public static void main(String[] args) {
        MultiThreadCopyFiles multiThreadCopyFiles = new MultiThreadCopyFiles();
        multiThreadCopyFiles.setPathSource("/home/aleksei/test/out/finalTest.odt");
        multiThreadCopyFiles.setPathDest("/home/aleksei/test/in/finalTest.odt");
        multiThreadCopyFiles.CopyFile();
    }
}
