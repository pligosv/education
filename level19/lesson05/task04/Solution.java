package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = reader.readLine();
        String result = reader.readLine();
        FileReader fileReader = new FileReader(source);
        FileWriter fileWriter = new FileWriter(result);
        while(fileReader.ready()){
            int data = fileReader.read();
            if(data==46){
                data=33;
            }
            fileWriter.write(data);
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
