package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        String name = "";
        List<String> list = new ArrayList<>();
        while (true) {
            if ("end".equals(path)) break;
            int mLastIndex = path.lastIndexOf(".");
            name = path.substring(0, mLastIndex);
            if (!list.contains(path)) {
                list.add(path);
            }
            path = reader.readLine();
        }
        Collections.sort(list);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(name));

        for (String s : list) {
            FileInputStream fileInputStream  = new FileInputStream(s);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        reader.close();
        fileOutputStream.close();
    }
}
