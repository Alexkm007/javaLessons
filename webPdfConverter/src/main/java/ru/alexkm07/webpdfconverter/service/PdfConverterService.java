package ru.alexkm07.webpdfconverter.service;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
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
@Data
@Slf4j
public class PdfConverterService implements InitializingBean, DisposableBean {

    private OfficeManager officeManager;


    public ConvertedFile convertToPdf(FileToConvert fileToConvert) throws OfficeException {

        String logs = String.format("Start converting file %s from user %s, doc number %s doc date %s",
                fileToConvert.getName(),fileToConvert.getUserName(),
                fileToConvert.getDocNumber(),fileToConvert.getDocDate());

        log.info(logs);
        LocalDateTime startDate = LocalDateTime.now();

        String path = FileUtil.saveFileToDisk(fileToConvert);
        File inputFile = new File(path);

        String newFileName = UUID.randomUUID().toString();
        File outputFile = new File(newFileName+".pdf");


        if (!officeManager.isRunning()) {
            try {
                afterPropertiesSet();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JodConverter.convert(inputFile).to(outputFile).execute();

        ConvertedFile cf = new ConvertedFile();
        cf.setName(outputFile.getName());
        try {
            cf.setConvertedData(Base64.getMimeEncoder().encodeToString(FileUtil.readFileFromDisk(outputFile.getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDateTime endDate = LocalDateTime.now();
        cf.setConvertedSec(Duration.between(startDate, endDate).toSeconds());
        inputFile.delete();
        outputFile.delete();
        logs = String.format("Ending converting file %s from user %s, doc number %s doc date %s",
                fileToConvert.getName(),fileToConvert.getUserName(),
                fileToConvert.getDocNumber(),fileToConvert.getDocDate());
        log.info(logs);
        return cf;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.officeManager = LocalOfficeManager.builder()
                .install()
                .hostName("localhost")
                .portNumbers(8100)
                .build();
        officeManager.start();
    }

    @Override
    public void destroy() throws Exception {
        OfficeUtils.stopQuietly(officeManager);
        officeManager.stop();
    }
}
