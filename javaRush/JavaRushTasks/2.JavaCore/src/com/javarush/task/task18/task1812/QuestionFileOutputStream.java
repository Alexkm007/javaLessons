package com.javarush.task.task18.task1812;

/* 
Расширяем AmigoOutputStream
*/


import java.io.*;

public class QuestionFileOutputStream implements AmigoOutputStream {
    private FileOutputStream stream;

    public QuestionFileOutputStream(String name) throws FileNotFoundException {
        this.stream = new FileOutputStream(name);
    }


    @Override
    public void flush() throws IOException {
       stream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(br.readLine().equals("Д")){
            stream.close();
        }
    }
}

