package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    int getCountOfEggsPerMonth() {
        return 1;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
