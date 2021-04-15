package ru.alex007;

import java.io.File;
import java.util.Date;

import com.sun.star.beans.PropertyValue;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XDesktop;
import com.sun.star.frame.XStorable;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.text.XTextDocument;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.util.XReplaceDescriptor;
import com.sun.star.util.XReplaceable;
import ooo.connector.BootstrapSocketConnector;

import java.io.*;


public class AppPdfConverter {
    public static void main(String[] args) throws Exception {

        String oooExeFolder = "C:/Program Files/OpenOffice.org 2.3/program/";
        // Initialise
        XComponentContext xContext = Bootstrap.bootstrap();

        XMultiComponentFactory xMCF = xContext.getServiceManager();

        Object oDesktop = xMCF.createInstanceWithContext(
                "com.sun.star.frame.Desktop", xContext);

        XDesktop xDesktop = (XDesktop) UnoRuntime.queryInterface(
                XDesktop.class, oDesktop);

        // Load the Document
        //String workingDir = "C:/projects/";
        //String myTemplate = workingDir + "letterTemplate.doc";
        String myTemplate = "test.doc";

        if (!new File(myTemplate).canRead()) {
            throw new RuntimeException("Cannot load template:" + new File(myTemplate));
        }

        XComponentLoader xCompLoader = (XComponentLoader) UnoRuntime
                .queryInterface(com.sun.star.frame.XComponentLoader.class, xDesktop);

         String sUrl = "file:///" + myTemplate;

        PropertyValue[] propertyValues = new PropertyValue[0];

        propertyValues = new PropertyValue[1];
        propertyValues[0] = new PropertyValue();
        propertyValues[0].Name = "Hidden";
        propertyValues[0].Value = new Boolean(true);
//
        XComponent xComp = xCompLoader.loadComponentFromURL(
                sUrl, "_blank", 0, propertyValues);


        // Manipulate
//        XReplaceDescriptor xReplaceDescr = null;
//        XReplaceable xReplaceable = null;
//
//        XTextDocument xTextDocument = (XTextDocument) UnoRuntime
//                .queryInterface(XTextDocument.class, xComp);
//
//        xReplaceable = (XReplaceable) UnoRuntime
//                .queryInterface(XReplaceable.class,
//                        xTextDocument);
//
//        xReplaceDescr = (XReplaceDescriptor) xReplaceable
//                .createReplaceDescriptor();
//
//        // mail merge the date
//        xReplaceDescr.setSearchString("<date>");
//        xReplaceDescr.setReplaceString(new Date().toString());
//        xReplaceable.replaceAll(xReplaceDescr);
//
//        // mail merge the addressee
//        xReplaceDescr.setSearchString("<addressee>");
//        xReplaceDescr.setReplaceString("Best Friend");
//        xReplaceable.replaceAll(xReplaceDescr);
//
//        // mail merge the signatory
//        xReplaceDescr.setSearchString("<signatory>");
//        xReplaceDescr.setReplaceString("John Steady");
//        xReplaceable.replaceAll(xReplaceDescr);


        // save as a PDF
        XStorable xStorable = (XStorable) UnoRuntime
                .queryInterface(XStorable.class, xComp);

//        propertyValues = new PropertyValue[2];
//        // Setting the flag for overwriting
//        propertyValues[0] = new PropertyValue();
//        propertyValues[0].Name = "Overwrite";
//        propertyValues[0].Value = new Boolean(true);
//        // Setting the filter name
//        propertyValues[1] = new PropertyValue();
//        propertyValues[1].Name = "FilterName";
//        propertyValues[1].Value = "writer_pdf_Export";

        // Appending the favoured extension to the origin document name
        //String myResult = workingDir + "letter1.pdf";
        String myResult  = "1.pdf";
        xStorable.storeToURL("file:///" + myResult, propertyValues);

        System.out.println("Saved " + myResult);


        // shutdown
        xDesktop.terminate();


    }

}


