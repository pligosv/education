package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null || string.isEmpty()) throw new  TooShortStringException();
        int count =0;
        int first = 0;
        int second =0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)=='\t'){
                count++;
                switch(count){
                    case 1: first=i; break;
                    case 2: second=i; break;
                    default:break;
                }
            }
        }
        if(count<2) throw new TooShortStringException();
        return string.substring(first,second).trim();
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
