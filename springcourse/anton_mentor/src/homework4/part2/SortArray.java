package homework4.part2;

public class SortArray {

    private int arrey[];

    public SortArray() {
    }

    public int[] getArrey() {
        return arrey;
    }

    public void setArrey(int[] arrey) {
        this.arrey = arrey;
    }

    public void initialArrey(int i) {
        arrey = new int[i];
        for (int j = 0; j < i; j++) {
            arrey[j] = (int) (Math.random() * 1000);
        }
    }

    public void printArrey() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arrey.length; i++) {
            if (i < arrey.length - 1) {
                sb.append(arrey[i]).append(",");
            } else sb.append(arrey[i]);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public void sort() {
        for (int step = arrey.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arrey.length; i++) {
                for (int j = i - step; j >= 0 && arrey[j] > arrey[j + step]; j -= step) {
                    int temp = arrey[j];
                    arrey[j] = arrey[j + step];
                    arrey[j + step] = temp;
                }
            }

        }

    }

}
