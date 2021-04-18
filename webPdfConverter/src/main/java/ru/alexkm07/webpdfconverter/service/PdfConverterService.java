package ru.alexkm07.webpdfconverter.service;

import ru.alexkm07.webpdfconverter.Model.ConvertedFile;
import ru.alexkm07.webpdfconverter.Model.FileToConvert;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.office.LocalOfficeManager;
import org.springframework.stereotype.Service;
import ru.alexkm07.webpdfconverter.fileutil.FileUtil;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@Service
public class PdfConverterService {

    public ConvertedFile convertToPdf(FileToConvert fileToConvert) throws OfficeException {


        LocalDateTime startDate = LocalDateTime.now();

        String path = FileUtil.saveFileToDisk(fileToConvert);
        File inputFile = new File(path);

        String newFileName = UUID.randomUUID().toString();
        File outputFile = new File(newFileName+".pdf");

        OfficeManager officeManager = LocalOfficeManager.builder()
                .install()
                .hostName("localhost")
                .portNumbers(8100)
                .build();
        officeManager.start();
        // convert
        JodConverter.convert(inputFile).to(outputFile).execute();

        OfficeUtils.stopQuietly(officeManager);
        officeManager.stop();

        ConvertedFile cf = new ConvertedFile();
        cf.setName(outputFile.getName());
        try {
            cf.setConvertedData(Base64.getMimeEncoder().encodeToString(FileUtil.readFileFromDisk(outputFile.getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDateTime endDate = LocalDateTime.now();
        cf.setConvertedSec(Duration.between(startDate, endDate).toSeconds());
        return cf;
    }

}
