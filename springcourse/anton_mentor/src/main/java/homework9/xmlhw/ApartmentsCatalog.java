package homework9.xmlhw;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement
public class ApartmentsCatalog {
    @XmlElement(name = "aprtment")
    private List<Apartment> apartments = new ArrayList();

    public ApartmentsCatalog() {
    }

    public ApartmentsCatalog(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }

    public List<Apartment> getApartmensWithCountRoom(int count){
        return apartments.stream().filter(i->i.getRoomCount()==count)
                .collect(Collectors.toList());
    }

    public void sellApartmen(Apartment apartment){
        apartments.remove(apartment);
    }

    public List<Apartment> getApartmetsBetweenCost(float costMin,float costMax){
        return apartments.stream().filter(i->i.getCost()>=costMin&&i.getCost()<=costMax)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ApartmentsCatalog{" +
                "apartments=" + apartments +
                '}';
    }
}
