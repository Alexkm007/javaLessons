package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory)) {
            Files.createDirectories(zipDirectory);
        }
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path p : fileNames) {
                    addNewZipEntry(zipOutputStream, source, p);
                }
            } else  if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else
                throw new PathIsNotFoundException();
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {

        Path fullPath = filePath.resolve(fileName);
        try(InputStream input = Files.newInputStream(fullPath)) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            //ZipEntry zipEntry = new ZipEntry(fileName.getFileName().toString());   ошибка:  удалил getFileName()
            zipOutputStream.putNextEntry(zipEntry);
            copyData(input, zipOutputStream);
            zipOutputStream.closeEntry();
    }}

    private void copyData(InputStream in, OutputStream out) throws Exception {
        int lenght;
        byte[] buffer = new byte[2048];
        while ((lenght = in.read(buffer)) >= 0) {
            out.write(buffer, 0, lenght);
        }
    }
}
