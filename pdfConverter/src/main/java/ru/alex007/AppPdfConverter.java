package ru.alex007;


import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.office.LocalOfficeManager;

import java.io.File;

public class AppPdfConverter {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        File inputFile = new File("test.xlsx");
        File outputFile = new File("test.pdf");

        // connect to an OpenOffice.org instance running on port 8100
//        OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
//        connection.connect();

        OfficeManager officeManager = LocalOfficeManager.builder()
                .install()
                .hostName("localhost")
                .portNumbers(8100)
                .build();
        officeManager.start();
        // convert
        JodConverter.convert(inputFile).to(outputFile).execute();
        // close the connection
        //connection.disconnect();
        OfficeUtils.stopQuietly(officeManager);
        officeManager.stop();
    }

}


