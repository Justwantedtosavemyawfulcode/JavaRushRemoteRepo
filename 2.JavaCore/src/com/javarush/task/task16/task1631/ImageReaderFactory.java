package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes image) {
        ImageReader imageReader;
        if (image == (ImageTypes.BMP)) {
            imageReader =  new BmpReader();
        }
        else if (image == (ImageTypes.JPG)) {
            imageReader = new JpgReader();
        }
        else if (image == (ImageTypes.PNG)) {
            imageReader = new PngReader();
        }
        else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return imageReader;
    }
}
