package BehavioralPatterns.State;

//Context
public class Radio {

    private Station station;

    public void setStation(Station station){
        this.station = station;
    }

   public void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioDFM());
        }else if(station instanceof RadioDFM){
            setStation(new VestiFM());
        }else if(station instanceof VestiFM){
            setStation(new Radio7());
        }
    }

    public void play(){
        this.station.play();
    }
}
