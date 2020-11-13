package homework3;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class CopyFiles {


    public static void copyFiles(String inPath, String outPath, String extension) throws IOException {

        File inFolder = new File(inPath);
        File[] files = inFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(extension.toLowerCase());
            }
        });
        File dest = new File(outPath);
        if(!dest.exists()){
            dest.mkdirs();
        }

        for(File file:files){
            Files.copy(file.toPath(), Paths.get(outPath+File.separator+file.getName()), StandardCopyOption.REPLACE_EXISTING );
        }
        System.out.println("Сopying completed!!!");
    }


    public static void main(String[] args) {

        String source = "C:\\test";
        String out = "C:\\test\\copy";
        String extension = ".odt";

        try {
            CopyFiles.copyFiles(source,out,extension);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

}
