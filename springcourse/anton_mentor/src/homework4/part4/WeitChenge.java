package homework4.part4;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeitChenge extends Thread {

    private File[] listFiles;
    private String pathChenges;

    public void setPathChenges(String pathChenges) {
        this.pathChenges = pathChenges;
    }

    @Override
    public void run() {

        while (true) {

            if (this.listFiles == null) {
                listFiles = new File(this.pathChenges).listFiles();
                continue;
            }

            File[] temp = new File(this.pathChenges).listFiles();
            List<File> listF = new ArrayList<File>(Arrays.asList(this.listFiles));
            List<File> tempList = new ArrayList<File>(Arrays.asList(temp));
            tempList.removeAll(listF);
            listF.removeAll(new ArrayList<File>(Arrays.asList(temp)));
            if (tempList.size() > 0) {
                for (File file : tempList) {
                    System.out.println("Найдено изменение добавлен: " + file.getName());
                    listFiles = new File(this.pathChenges).listFiles();
                }

             //   break;
            }
            if (listF.size() > 0) {
                for (File file : listF) {
                    System.out.println("Найдено изменение удален: " + file.getName());
                    listFiles = new File(this.pathChenges).listFiles();
                }
              //  break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
