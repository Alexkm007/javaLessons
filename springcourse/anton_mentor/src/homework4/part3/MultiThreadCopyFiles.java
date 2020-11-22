package homework4.part3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadCopyFiles {
    private String pathSource;
    private String pathDest;

    public MultiThreadCopyFiles() {
    }

    public void setPathSource(String pathSource) {
        this.pathSource = pathSource;
    }

    public void setPathDest(String pathDest) {
        this.pathDest = pathDest;
    }

    private void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public void copyAllFiles(int countOfThread) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(countOfThread);
        File source = new File(pathSource);
        File[] files = source.listFiles();
        List<Future> futures = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) continue;
            Callable<Boolean> task = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    copyFile(file, new File(pathDest + File.separator + file.toPath().getFileName()));
                    return true;
                }
            };
            futures.add(es.submit(task));
        }
        for (Future future : futures) {
            future.get();
        }
        es.shutdown();
    }

}
