package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(path1);
        FileInputStream fileInputStream1 = new FileInputStream(path2);

        byte[] buffer = new byte[fileInputStream.available()];
        byte[] buffer1 = new byte[fileInputStream1.available()];
        if (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);
        }
        if (fileInputStream1.available() > 0) {
            fileInputStream1.read(buffer1);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(path1, true);

        fileOutputStream1.write(buffer1);
        fileOutputStream1.write(buffer);

        reader.close();
        fileInputStream.close();
        fileInputStream1.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
