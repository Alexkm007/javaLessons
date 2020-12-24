package xmlLessons.coreXml;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = CatalogXMLWorker.loadCatalogFromXMLFile(
                new File("./src/xmlLessons/test.xml")
        );
        CatalogXMLWorker.saveToXML(catalog,"./src/xmlLessons/testOut.xml");

        System.out.println(catalog);
    }
}
