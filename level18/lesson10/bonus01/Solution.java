package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int key = 10;

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        String argument = args[0];
        switch (argument){
            case "-e":
                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                    fileOutputStream.write(data+key);
                }
                break;
            case "-d":
                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                    fileOutputStream.write(data-key);
                }
                break;
        }

        fileInputStream.close();
        fileOutputStream.close();


    }

}
