package homework5.part1;

public class Ship {
    private int countOfBoxes;
    private String name;

    public Ship() {
    }

    public Ship(String name,int countOfBoxes) {
        this.countOfBoxes = countOfBoxes;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountOfBoxes(int countOfBoxes) {
        this.countOfBoxes = countOfBoxes;
    }

    public int getCountOfBoxes() {
        return countOfBoxes;
    }
}
