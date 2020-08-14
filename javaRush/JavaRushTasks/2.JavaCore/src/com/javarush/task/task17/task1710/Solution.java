package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        if(args.length == 4){
            addPerson(args);
        }

        if(args.length == 5){
            udatePerson(args);
        }

        if(args.length == 2 && args[0].equals("-d")){
            dellitePerson(Integer.parseInt(args[1]));
        }
        if(args.length == 2 && args[0].equals("-i")){
            printPerson(Integer.parseInt(args[1]));
        }


    }

    private static void printPerson(int id) {
        System.out.println(allPeople.get(id).toString());
    }

    private static void dellitePerson(int id) {
        Person p = allPeople.get(id);
        p.setBirthDate(null);
        p.setName(null);
        p.setSex(null);
        allPeople.set(id,p);
    }

    public static void addPerson(String[] args) throws ParseException {
        if(!args[0].equals("-c")){
            return;
        }
        String name = args[1];
        Sex sex;
        if(args[2].equals("м")){
            sex = Sex.MALE;
        }else {
            sex = Sex.FEMALE;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        Date bd = formatter.parse(args[3]);
        if(sex == Sex.MALE) {
            allPeople.add(Person.createMale(name,bd));
        }else {
            allPeople.add(Person.createFemale(name,bd));
        }
        System.out.println(allPeople.size()-1);
    }

    public static void udatePerson(String[] args) throws ParseException {
        if(!args[0].equals("-u")){
            return;
        }
        int id = Integer.parseInt(args[1]);
        String name = args[2];
        Sex sex;
        if(args[3].equals("м")){
            sex = Sex.MALE;
        }else {
            sex = Sex.FEMALE;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        Date bd = formatter.parse(args[4]);
        Person p = allPeople.get(id);
        p.setBirthDate(bd);
        p.setName(name);
        p.setSex(sex);
        allPeople.set(id,p);
    }



}
