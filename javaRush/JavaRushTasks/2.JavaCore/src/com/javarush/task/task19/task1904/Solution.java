package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

//        Scanner scanner= new Scanner(new File("c:\\test\\1.txt"));
//        PersonScannerAdapter pscan = new PersonScannerAdapter(scanner);
//        Person  p = pscan.read();
//        pscan.close();
//        System.out.println(p);

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String str = fileScanner.nextLine();
            try {
                return returnPersonFromStr(str);
            } catch (Exception e){
                return null;
            }

        }

        private Person returnPersonFromStr(String str) throws ParseException {

            String[] data = str.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(data[5]),
                    Integer.parseInt(data[4]) - 1, Integer.parseInt(data[3]));

            return new Person(data[1],data[2],data[0],calendar.getTime());
        }


        @Override
        public void close() throws IOException {
                fileScanner.close();
        }
    }
}
