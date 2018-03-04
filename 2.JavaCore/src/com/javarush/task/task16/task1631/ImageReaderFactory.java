package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory implements ImageReader {
    public static ImageReader getImageReader(ImageTypes it) {
        if (it == ImageTypes.BMP) return new BmpReader();
        if (it == ImageTypes.JPG) return new JpgReader();
        if (it == ImageTypes.PNG) return new PngReader();
        throw new IllegalArgumentException();
    }
}
