package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path1=args[0];
        String path2=args[1];

        BufferedReader reader = new BufferedReader(new FileReader(path1));
        FileWriter writer = new FileWriter(path2);
        StringBuilder sb =new StringBuilder();
        while(reader.ready()){
            String[] split = reader.readLine().split(" ");
            for (String s : split) {
                if(s.length()>6){
                    sb.append(s).append(",");
                }
            }
        }
        String result = sb.substring(0,sb.length()-1);
        writer.write(result);
        reader.close();
        writer.close();
    }
}
