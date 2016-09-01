package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Владимир on 01.09.2016.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes types) {

        if (types == ImageTypes.JPG)
            return new JpgReader();
        else if (types == ImageTypes.PNG)
            return new PngReader();
        else if (types == ImageTypes.BMP)
            return new BmpReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");


    }
}
