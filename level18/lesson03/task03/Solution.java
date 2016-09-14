package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (!map.containsKey(data)) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() > max) {
                max = integerIntegerEntry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == max) {
                System.out.print(integerIntegerEntry.getKey() + " ");
            }
        }

        fileInputStream.close();
        reader.close();
    }
}
