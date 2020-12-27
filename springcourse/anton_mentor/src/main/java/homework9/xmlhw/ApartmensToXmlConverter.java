package homework9.xmlhw;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ApartmensToXmlConverter {

    public static void saveToXmlFile(ApartmentsCatalog apartmentsCatalog, File file){
        try{
            JAXBContext jaxbc = JAXBContext.newInstance(ApartmentsCatalog.class);
            Marshaller marshaller = jaxbc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(apartmentsCatalog, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static ApartmentsCatalog loadFromXmlFile(File file){

        JAXBContext jaxbC = null;
        try {
            jaxbC = JAXBContext.newInstance(ApartmentsCatalog.class);
            Unmarshaller unmarshaller = jaxbC.createUnmarshaller();
            ApartmentsCatalog apartmentsCatalog = (ApartmentsCatalog) unmarshaller.unmarshal(file);
            return apartmentsCatalog;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
