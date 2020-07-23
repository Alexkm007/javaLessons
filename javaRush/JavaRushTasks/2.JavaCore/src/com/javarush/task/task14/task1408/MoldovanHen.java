package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    int getCountOfEggsPerMonth() {
        return 3;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
