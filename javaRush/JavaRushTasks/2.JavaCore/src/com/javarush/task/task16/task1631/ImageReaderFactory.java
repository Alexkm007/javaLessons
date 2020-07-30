package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){
        if(ImageTypes.BMP == type){
            return new BmpReader();
        }
        if(ImageTypes.JPG == type){
            return new JpgReader();
        }
        if(ImageTypes.PNG == type){
            return new PngReader();
        }

        throw new IllegalArgumentException();
    }
}
