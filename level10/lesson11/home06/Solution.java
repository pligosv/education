package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        String lastName;
        int age;
        int height;
        int weight;
        String city;

        public Human(String name){
            this.name=name;
        }
        public Human(String name, String lastName, int age, String city) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public Human(String lastName, int age, int height, int weight, String city) {

            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.city = city;
        }
        public Human( int age, int height, int weight, String city) {

            this.age = age;
            this.height = height;
            this.weight = weight;
            this.city = city;
        }
        public Human( int height, int weight, String city) {

            this.height = height;
            this.weight = weight;
            this.city = city;
        }

        public Human(String name, String lastName){
            this.name=name;
            this.lastName=lastName;
        }
        public Human(String name, String lastName,int age){
            this.name=name;
            this.lastName=lastName;
            this.age=age;
        }
        public Human(String name, String lastName, int age, int height, int weight) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, String lastName, int age, int height) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
        }

        public Human(String name, String lastName, int age, int height, int weight, String city) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.city = city;
        }
    }
}
