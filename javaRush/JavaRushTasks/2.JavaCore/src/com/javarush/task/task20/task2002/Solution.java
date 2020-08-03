package com.javarush.task.task20.task2002;

import javafx.scene.input.DataFormat;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            user1.setFirstName("Shuka");
            user1.setLastName("Rybin");
            Calendar calendar = new GregorianCalendar(1980,0,22);
            user1.setBirthDate(calendar.getTime());
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject)){
                System.out.println("ok");
            } else System.out.println("no");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static String userToString(User user){

        String str = (user.getFirstName() + ";"+ user.getLastName()+";"
                +user.isMale()+";"+user.getCountry() +";"+user.getBirthDate().getTime());

        return str;
    }

    public static User.Country returnCountry(String country){
        switch (country){
            case "RUSSIA":return User.Country.RUSSIA;
            case "UKRAINE":return User.Country.UKRAINE;
            default:
                return User.Country.OTHER;
        }

    }
    public static Date returnBD(String date) throws ParseException {
        Date bd = new Date(Long.parseLong(date));
        return bd;
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {

            for(User user:users){
                String usstr = userToString(user)+System.lineSeparator();
                outputStream.write(usstr.getBytes());
            }

        }

        public void load(InputStream inputStream) throws Exception {
            byte[] buff = new byte[inputStream.available()];
            inputStream.read(buff);
            String in = new String(buff);
            String[] users =in.split(System.lineSeparator());
            for(String user:users){
                String[] userdata = user.trim().split(";");
                if(userdata.length==5){
                    User objUser = new User();
                    objUser.setFirstName(userdata[0]);
                    objUser.setLastName(userdata[1]);
                    objUser.setMale(Boolean.parseBoolean(userdata[2]));
                    objUser.setCountry(returnCountry(userdata[3]));
                    objUser.setBirthDate(returnBD(userdata[4]));
                    this.users.add(objUser);
                }else continue;
            }

        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
