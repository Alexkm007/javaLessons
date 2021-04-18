package ru.alexkm07.webpdfconverter.Model;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class FileToConvert implements Serializable {
    @NonNull
    private String name;
    @NonNull
    private String fileExtension;
    private String dataToConvert;
}
