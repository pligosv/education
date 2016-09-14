package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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
        int min = map.values().iterator().next();
        for (Integer integer : map.values()) {
            int tmp = integer;
            if (tmp < min) min = tmp;
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == min) {
                System.out.print(integerIntegerEntry.getKey() + " ");
            }
        }

    }
}
