package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<String,String>();
        map.put("Иванов","Иван");
        map.put("Иванов2","Иван2");
        map.put("Иванов","Иван");
        map.put("Иванов4","Иван4");
        map.put("Иванов5","Иван5");
        map.put("Иванов67","Иван");
        map.put("Иванов","Иван7");
        map.put("Иванов8","Иван8");
        map.put("Иванов9","Иван9");
        map.put("Иванов11","Иван11");


        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
