package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = reader.readLine();
        String result = reader.readLine();

        StringBuilder sb = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(source));

        FileReader fileReader = new FileReader(source);
        FileWriter fileWriter = new FileWriter(result);
        while (fileReader.ready()) {
            int data = fileReader.read();
            sb.append((char) data);
        }
        String str = sb.toString();
        String[] finalStr = str.split(" ");
        for (String s : finalStr) {
            boolean b = false;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if ((int) aChar >= 49 && (int) aChar <= 57) {
                    b = true;
                } else {
                    b = false;
                    break;
                }
            }
            if (b) {
                fileWriter.write(s + " ");
            }
        }
        reader.close();
        bufferedReader.close();
        fileWriter.close();
        fileReader.close();
    }
}
