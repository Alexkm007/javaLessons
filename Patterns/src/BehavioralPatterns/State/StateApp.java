package BehavioralPatterns.State;

public class StateApp {
    public static void main(String[] args) {
        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for(int i = 0; i<10;i++){
            radio.nextStation();
            radio.play();
        }

    }
}
