package dz2.students.sort;

public class SortingType {
    private Sortby sortby;
    private UpDown upDown;

    public SortingType() {
    }

    public SortingType(Sortby sortby, UpDown upDown) {
        this.sortby = sortby;
        this.upDown = upDown;
    }

    public Sortby getSortby() {
        return sortby;
    }

    public void setSortby(Sortby sortby) {
        this.sortby = sortby;
    }

    public UpDown getUpDown() {
        return upDown;
    }

    public void setUpDown(UpDown upDown) {
        this.upDown = upDown;
    }
}
