package homework5.part3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadSearchFile {
    private String startFolderSearch;
    private String nameToSearh;
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private ConcurrentLinkedQueue<Future<Boolean>> tasks = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<String> files = new ConcurrentLinkedQueue<>();

    public MultiThreadSearchFile() {
    }

    public String getNameToSearh() {
        return nameToSearh;
    }

    public void setNameToSearh(String nameToSearh) {
        this.nameToSearh = nameToSearh;
    }

    public String getStartFolderSearch() {
        return startFolderSearch;
    }

    public void setStartFolderSearch(String startFolderSearch) {
        this.startFolderSearch = startFolderSearch;
    }

    private void addtoList(String fileName) {
        files.offer(fileName);
    }

    private void addTaskToSearch(File path) {
        Callable<Boolean> task = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                searchFileInDirectory(path);
                return true;
            }
        };
        tasks.offer(executorService.submit(task));
    }

    private void searchFileInDirectory(File folder) {
        File[] files = folder.listFiles();
        //System.out.println("Ищу в папке " + folder.getAbsoluteFile());
        if (files == null || folder.isHidden()) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                addTaskToSearch(file);
            } else if (file.getName().equalsIgnoreCase(nameToSearh)) {
                addtoList(file.toString());
            }
        }
    }

    public void searchFile() {
        searchFileInDirectory(new File(startFolderSearch));
        try {
            Thread.sleep(100);
            Future<Boolean> task = tasks.poll();
            task.get();
            while (task != null) {
                task = tasks.poll();
                if (task != null) {
                    task.get();
                }
            }
            executorService.shutdown();
            if (files.size() == 0) {
                System.out.println("Файлы не найдены");}
            else{
                System.out.println("Найдены файлы:");
            }
            for (String name : files) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
