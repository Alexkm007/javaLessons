package homework9.xmlhw;

import java.io.File;
import java.util.List;

public class MainXml {
    public static void main(String[] args) {

        ApartmentsCatalog apartmentsCatalog = new ApartmentsCatalog();
        apartmentsCatalog.addApartment(new Apartment(2,"sbp 32",5,700000));
        apartmentsCatalog.addApartment(new Apartment(3,"sbp 32",30,800000));
        apartmentsCatalog.addApartment(new Apartment(1,"sbp 32",15,450000));
        apartmentsCatalog.addApartment(new Apartment(3,"sbp 32",21,670000));
        apartmentsCatalog.addApartment(new Apartment(1,"sbp 32",7,500000));
        apartmentsCatalog.addApartment(new Apartment(2,"sbp 32",1,700000));

        File xmlSave = new File("./src/main/java/homework9/test.xml");

        ApartmensToXmlConverter.saveToXmlFile(apartmentsCatalog, xmlSave);
        ApartmentsCatalog apartmentsCatalogOne = ApartmensToXmlConverter.loadFromXmlFile(xmlSave);
        List<Apartment> apartments = apartmentsCatalogOne.getApartments();
        System.out.println(apartmentsCatalog);
        Apartment apartment = apartments.get(0);
        apartmentsCatalogOne.sellApartmen(apartment);
        ApartmensToXmlConverter.saveToXmlFile(apartmentsCatalogOne, xmlSave);
        apartmentsCatalog = ApartmensToXmlConverter.loadFromXmlFile(xmlSave);

        apartment = apartmentsCatalog.getApartments().get(0);
        apartment.setCost(35000);
        ApartmensToXmlConverter.saveToXmlFile(apartmentsCatalog,xmlSave);
        apartmentsCatalog = ApartmensToXmlConverter.loadFromXmlFile(xmlSave);
        System.out.println(apartmentsCatalog);

        System.out.println(apartmentsCatalogOne);
        System.out.println(apartmentsCatalogOne.getApartmensWithCountRoom(2));
        System.out.println(apartmentsCatalogOne.getApartmetsBetweenCost(550000,1000000));
    }
}
