package homework4;

public class ArreySumm {

    private int[] arrey;

    public ArreySumm() {
    }

    public int[] getArrey() {
        return arrey;
    }

    public void setArrey(int[] arrey) {
        this.arrey = arrey;
    }

    public void initialArrey(int i){
        arrey = new int[i];
        for(int j = 0;j <i;j++){
            arrey[j] = (int)(Math.random() * 10);
        }
    }

    public long summArrey(){
        long x = 0;
        for(int j:getArrey()){
            x+=j;
        }
        return x;
    }

}
