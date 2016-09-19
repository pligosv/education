package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        String path3 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path2);
        FileInputStream fileInputStream2 = new FileInputStream(path3);
        FileOutputStream fileOutputStream = new FileOutputStream(path1, true);
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }
        while (fileInputStream2.available() > 0) {
            int data = fileInputStream2.read();
            fileOutputStream.write(data);
        }
        reader.close();
        fileInputStream.close();
        fileInputStream2.close();
        fileOutputStream.close();


    }
}
