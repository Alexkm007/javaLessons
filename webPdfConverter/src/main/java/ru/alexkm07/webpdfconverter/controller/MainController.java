package ru.alexkm07.webpdfconverter.controller;

import org.jodconverter.core.office.OfficeException;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import ru.alexkm07.webpdfconverter.Model.ConvertedFile;
import ru.alexkm07.webpdfconverter.Model.FileToConvert;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.webpdfconverter.service.PdfConverterService;

@RequestMapping("")
@RestController
public class MainController {

    private final PdfConverterService pdfConverterService;

    public MainController(PdfConverterService pdfConverterService) {
        this.pdfConverterService = pdfConverterService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvertedFile ConvertedFile(@Validated @RequestBody FileToConvert fileToConvert){
        ConvertedFile convertedFile = null;
        try {
            convertedFile = pdfConverterService.convertToPdf(fileToConvert);
        } catch (OfficeException e) {
            convertedFile = new ConvertedFile();
        }
        return convertedFile;
    }

}
