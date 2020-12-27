package homework9.xmlhw;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Apartment {
    private int roomCount;
    private String adress;
    private int floor;
    private float cost;

    public Apartment() {
    }

    public Apartment(int roomCount, String adress, int floor, float cost) {
        this.roomCount = roomCount;
        this.adress = adress;
        this.floor = floor;
        this.cost = cost;
    }

    @XmlElement
    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @XmlElement
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @XmlElement
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @XmlElement
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "roomCount=" + roomCount +
                ", adress='" + adress + '\'' +
                ", floor=" + floor +
                ", cost=" + cost +
                '}';
    }
}
