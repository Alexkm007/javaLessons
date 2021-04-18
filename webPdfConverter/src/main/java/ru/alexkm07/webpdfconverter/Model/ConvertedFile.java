package ru.alexkm07.webpdfconverter.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConvertedFile implements Serializable {
    private String name;
    private Long convertedSec;
    private String convertedData;
}
