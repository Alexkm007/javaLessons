package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            if(ivanov.equals(somePerson)){
                System.out.println("OK");
            }else {
                System.out.println("NO");
            }
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {

            String outAsets ="#";
            if(assets.size()>0){
            for(Asset aset:assets){
                outAsets+=aset.getName()+":"+aset.getPrice()+";";
            }}else {outAsets+="n/a";}
            String out = name + outAsets;
            outputStream.write(out.getBytes());

        }

        public void load(InputStream inputStream) throws Exception {

            byte[] buff= new byte[inputStream.available()];
            while (inputStream.available()>0){
                inputStream.read(buff);
            }
            String in = new String(buff);
            String[] strObj = in.split("#");
            name = strObj[0];
            if(!strObj[1].equals("n/a")){
                String[] assetsstr = strObj[1].split(";");
                for(String assetstr:assetsstr){
                    String[] assetobj = assetstr.split(":");
                    assets.add(new Asset(assetobj[0],Double.parseDouble(assetobj[1])));
                }
            }
        }
    }
}
