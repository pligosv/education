package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String path3 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(path1);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(path3);

        byte[] buffer1 = new byte[fileInputStream.available() / 2 + fileInputStream.available() % 2];
        fileOutputStream.write(buffer1, 0, fileInputStream.read(buffer1));
        fileOutputStream2.write(buffer1, 0, fileInputStream.read(buffer1));

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream2.close();
    }
}
