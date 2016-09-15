package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String first = args[0].substring(1);


        switch (first) {
            case "c":
                create(args);
                break;
            case "u":
                update(args);
                break;
            case "d":
                delete(args);
                break;
            case "i":
                info(args);
                break;
        }
    }

    public synchronized static void create(String[] args) throws ParseException {
        String[] infoArray = new String[3];
        String[] array = new String[args.length - 1];
        System.arraycopy(args, 1, array, 0, args.length - 1);

        for (int i = 0; i < array.length; i += 3) {
            System.arraycopy(array, i, infoArray, 0, 3);

            String sex = infoArray[1];
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            if ("м".equals(sex)) {
                allPeople.add(Person.createMale(infoArray[0], format.parse(infoArray[2])));
            } else {
                allPeople.add(Person.createFemale(infoArray[0], format.parse(infoArray[2])));
            }
            System.out.println(allPeople.size() - 1);
        }

    }

    public synchronized static void update(String[] args) throws ParseException {
        String[] infoArray = new String[4];
        String[] array = new String[args.length - 1];
        System.arraycopy(args, 1, array, 0, args.length - 1);


        for (int i = 0; i < array.length; i += 4) {
            System.arraycopy(array, i, infoArray, 0, 4);

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Person person = allPeople.get(Integer.parseInt(infoArray[0]));
            person.setName(infoArray[1]);
            if ("м".equals(infoArray[2])) {
                person.setSex(Sex.MALE);
            } else {
                person.setSex(Sex.FEMALE);
            }
            person.setBirthDay(format.parse(infoArray[3]));

        }
    }

    public synchronized static void delete(String[] args) {
        String[] infoArray = new String[1];
        String[] array = new String[args.length - 1];
        System.arraycopy(args, 1, array, 0, args.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array, i, infoArray, 0, 1);

            Person person1 = allPeople.get(Integer.parseInt(infoArray[0]));
            person1.setBirthDay(null);
            person1.setSex(null);
            person1.setName(null);
        }
    }

    public static void info(String[] args) {
        String[] infoArray = new String[1];
        String[] array = new String[args.length - 1];
        System.arraycopy(args, 1, array, 0, args.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array, i, infoArray, 0, 1);

            Person person2 = allPeople.get(Integer.parseInt(infoArray[0]));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            StringBuilder sb = new StringBuilder();
            String sexPerson = person2.getSex() == Sex.MALE ? "м" : "ж";
            sb.append(person2.getName()).append(" ");
            sb.append(sexPerson).append(" ");
            sb.append(simpleDateFormat.format(person2.getBirthDay()));
            System.out.println(sb.toString());
        }

    }
}
