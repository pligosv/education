package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gFatherName = reader.readLine();
        Cat gFather = new Cat(gFatherName);

        String gMotherName = reader.readLine();
        Cat gMother = new Cat(gMotherName);

        String fatherName = reader.readLine();
        Cat father = new Cat(fatherName,gFather,null);

        String motherName = reader.readLine();
        Cat mother = new Cat(motherName,null,gMother);

        String sonName=reader.readLine();
        Cat son= new Cat(sonName,father,mother);

        String daughterName=reader.readLine();
        Cat daughter= new Cat(daughterName,father,mother);

        System.out.println(gFather);
        System.out.println(gMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parentMother;
        private Cat parentFather;

        Cat(String name){
            this.name=name;
        }


        Cat(String name, Cat parentFather, Cat parentMother)
        {
            this.name = name;
            this.parentMother = parentMother;
            this.parentFather = parentFather;
        }

        @Override
        public String toString()
        {
            return "Cat name is "
                    + name
                    +((parentMother==null)?", no mother":", mother is "+parentMother.name)
                    +((parentFather==null)?", no father":", father is "+parentFather.name);
        }
    }

}
