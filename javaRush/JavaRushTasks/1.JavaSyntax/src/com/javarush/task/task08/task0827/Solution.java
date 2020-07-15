package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Date ddate = dateFormat.parse(date);
        String year = "" + (1900 +ddate.getYear());
        String sny = "JANUARY 1 " + (year);
        Date bdate = dateFormat.parse(sny);
        long day = (ddate.getTime() - bdate.getTime())/(3600*24*1000);
        //day--;
        if (day%2==0) {
            return true;
        } else {
            return false;
        }


    }
}
