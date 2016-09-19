package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(path1));
        FileWriter fileWriter = new FileWriter(path2);
        String numbers = fileReader.readLine();
        String[] array = numbers.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(Math.round(Double.parseDouble(array[i]))).append(" ");
        }
        String result = sb.toString();
        fileWriter.write(result);


        reader.close();
        fileReader.close();
        fileWriter.close();

    }
}
