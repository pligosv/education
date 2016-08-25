package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
        InputStream inputStream = new FileInputStream(name);
        Scanner scanner=new Scanner(inputStream);

        while (inputStream.available()>0){
            while(scanner.hasNextInt()) {
                int data = scanner.nextInt();
                arrayList.add(data);
            }
        }

        reader.close();
        inputStream.close();
        scanner.close();
        Collections.sort(arrayList);
        for (Integer integer : arrayList) {
             if(integer%2==0) System.out.println(integer);
        }

    }
}
