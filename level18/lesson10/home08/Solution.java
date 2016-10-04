package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        while (true) {
            if ("exit".equals(path)) break;
            ReadThread readThread = new ReadThread(path);
            readThread.start();
            readThread.join();
            path = reader.readLine();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private String name;

        public ReadThread(String fileName) {
            name = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            Map<Integer, Integer> map = new HashMap<>();
            try {
                FileInputStream fileInputStream = new FileInputStream(name);
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    if (!map.containsKey(data)) {
                        map.put(data, 1);
                    } else {
                        map.put(data, map.get(data) + 1);
                    }
                }
                int max = 0;
                int data = 0;
                for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                    if (integerIntegerEntry.getValue() >= max) {
                        max = integerIntegerEntry.getValue();
                        data = integerIntegerEntry.getKey();
                    }
                }
                resultMap.put(name, data);
                fileInputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
