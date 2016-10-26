package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path1 = args[0];
        String path2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(path1));
        StringBuilder sb = new StringBuilder();
        FileWriter fileWriter = new FileWriter(path2);

        while(reader.ready()){
            sb.append(reader.readLine());
        }
        String[] split = sb.toString().split(" ");
        for (String s : split) {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){
                fileWriter.write(s+" ");
            }
        }
        reader.close();
        fileWriter.close();
    }
}
