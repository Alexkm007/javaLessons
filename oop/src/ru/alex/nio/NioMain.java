package ru.alex.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioMain {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {

        Path file = Paths.get("nio-data.txt");
        file = file.toAbsolutePath();
        System.out.println(Files.exists(file));
        System.out.println(file);

        RandomAccessFile aFile = new RandomAccessFile(file.toString(),"r");
        FileChannel fc = aFile.getChannel();
        System.out.println(fc.isOpen());
        System.out.println(Files.size(file));

        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        int byteRead = fc.read(buff);
        System.out.println(byteRead);
        buff.flip();
        fc.close();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
        buff.clear();
    }
}
