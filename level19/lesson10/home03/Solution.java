package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Calendar calendar = new GregorianCalendar();

        while (reader.ready()) {
            String[] split = reader.readLine().split(" ");
            String name = split[0];
            int year, month, day;
            year = Integer.parseInt(split[split.length - 1]);
            month = Integer.parseInt(split[split.length - 2]);
            day = Integer.parseInt(split[split.length - 3]);
            for (int i = 1; i < split.length - 3; i++) {
                name += " " + split[i];
            }
            calendar.set(year, month - 1, day);
            PEOPLE.add(new Person(name, calendar.getTime()));
        }
        for (Person person : PEOPLE) {
            System.out.println(person.getName() + " " + person.getBirthday());
        }

        reader.close();
    }

}
