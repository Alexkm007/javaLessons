package homework6.streams.part2;

public class MaxInList {
    private DataProvider dataProvider;

    public MaxInList() {
    }

    public MaxInList(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public float returnMax(){
        float var = dataProvider.returnData()
                .stream()
                .max(Float::compare)
                .get();
        return var;
    }

}
