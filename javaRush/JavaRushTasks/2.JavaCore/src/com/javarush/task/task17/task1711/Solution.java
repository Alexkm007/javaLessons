package com.javarush.task.task17.task1711;

import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {

    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length == 0) {
            return;
        }
        List<Map> rowPersons;
        switch (args[0]) {

            case "-c":
                synchronized (allPeople) {
                    rowPersons = returnRowPersons(args, false);
                    for (Map pers : rowPersons) {
                        addPerson(pers);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    rowPersons = returnRowPersons(args, true);
                    for (Map pers : rowPersons) {
                        udatePerson(pers);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        dellitePerson(Integer.parseInt(args[i]));
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        printPerson(Integer.parseInt(args[i]));
                    }
                }
        }

    }

    private static List<Map> returnRowPersons(String[] args, boolean isUpdate) {
        List<Map> rowPersons = new ArrayList<>();
        if (!isUpdate) {
            for (int i = 1; i < args.length; i += 3) {
                Map<String, String> person = new HashMap<>();
                person.put("name", args[i]);
                person.put("sex", args[i + 1]);
                person.put("bd", args[i + 2]);
                rowPersons.add(person);
            }
        } else {
            for (int i = 1; i < args.length; i += 4) {
                Map<String, String> person = new HashMap<>();
                person.put("name", args[i + 1]);
                person.put("sex", args[i + 2]);
                person.put("bd", args[i + 3]);
                person.put("id", args[i]);
                rowPersons.add(person);
            }
        }
        return rowPersons;
    }

    private static void printPerson(int id) {
        System.out.println(allPeople.get(id).toString());
    }

    private static void dellitePerson(int id) {
        Person p = allPeople.get(id);
        p.setBirthDate(null);
        p.setName(null);
        p.setSex(null);
        allPeople.set(id, p);
    }

    public static void addPerson(Map<String, String> pers) throws ParseException {
//        if(!args[0].equals("-c")){
//            return;
//        }
        String name = pers.get("name");
        Sex sex;
        if (pers.get("sex").equals("м")) {
            sex = Sex.MALE;
        } else {
            sex = Sex.FEMALE;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        Date bd = formatter.parse(pers.get("bd"));
        if (sex == Sex.MALE) {
            allPeople.add(Person.createMale(name, bd));
        } else {
            allPeople.add(Person.createFemale(name, bd));
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void udatePerson(Map<String, String> pers) throws ParseException {

        int id = Integer.parseInt(pers.get("id"));
        String name = pers.get("name");
        Sex sex;
        if (pers.get("sex").equals("м")) {
            sex = Sex.MALE;
        } else {
            sex = Sex.FEMALE;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        Date bd = formatter.parse(pers.get("bd"));
        Person p = allPeople.get(id);
        p.setBirthDate(bd);
        p.setName(name);
        p.setSex(sex);
        allPeople.set(id, p);
    }


}
