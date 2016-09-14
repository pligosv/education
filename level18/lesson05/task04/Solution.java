package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path1);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);

        byte[] buffer = new byte[fileInputStream.available()];
        byte[] reverse = new byte[fileInputStream.available()];
        int count = fileInputStream.read(buffer);

        for (int i = 0; i < buffer.length; i++) {
            reverse[i] = buffer[buffer.length - i - 1];
        }

        fileOutputStream.write(reverse);

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
