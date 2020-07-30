package com.javarush.task.task18.task1814;

import java.io.*;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String[] str = fileName.split("\\.");
        if(!str[str.length-1].equals("txt")){
           super.close();
           throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args)  {
    }
}

