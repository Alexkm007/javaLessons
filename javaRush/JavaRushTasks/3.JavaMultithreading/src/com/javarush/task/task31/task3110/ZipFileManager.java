package com.javarush.task.task31.task3110;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             InputStream is = Files.newInputStream(source)) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);
            int i = is.available();
            byte[] buffer = new byte[i];
            is.read(buffer);
            zipOutputStream.write(buffer);
            zipOutputStream.closeEntry();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
