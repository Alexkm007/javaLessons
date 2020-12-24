package xmlLessons.javactest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBWorker {

    public static void saveToXmlFile(Trains trains, File file){
        try{
            JAXBContext jaxbc = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(trains, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Trains loadFromXmlFile(File file){

        JAXBContext jaxbC = null;
        try {
            jaxbC = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = jaxbC.createUnmarshaller();
            Trains trains = (Trains) unmarshaller.unmarshal(file);
            return trains;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
