package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int code = 44;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);
        int count = 0;
        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == code) count++;
        }
        System.out.println(count);
        reader.close();
        fileInputStream.close();
    }
}
