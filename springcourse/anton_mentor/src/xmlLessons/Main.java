package xmlLessons;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = CatalogXMLWorker.loadCatalogFromXMLFile(
                new File("./src/xmlLessons/test.xml")
        );
        System.out.println(catalog);
    }
}
