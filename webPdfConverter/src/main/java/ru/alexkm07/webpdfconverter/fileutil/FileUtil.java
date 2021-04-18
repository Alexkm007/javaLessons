package ru.alexkm07.webpdfconverter.fileutil;


import ru.alexkm07.webpdfconverter.Model.FileToConvert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class FileUtil {

    public static String saveFileToDisk(FileToConvert fileToConvert) {
        String fileName = UUID.randomUUID().toString() + fileToConvert.getFileExtension();
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytesEncoded = Base64.getMimeDecoder().decode(fileToConvert.getDataToConvert());
            fos.write(bytesEncoded);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public static byte[] readFileFromDisk(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path);
        return data;
    }

}


