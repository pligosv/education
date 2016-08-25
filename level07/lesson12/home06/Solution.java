package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gF1=new Human("Иваныч",true,70,null,null);
        Human gF2=new Human("Петрович",true,75,null,null);
        Human gM1=new Human("Матрена",false,65,null,null);
        Human gM2=new Human("Надюша",false,63,null,null);
        Human f=new Human("Отец",true,40,gF1,gM1);
        Human m=new Human("Мама",false,35,gF2,gM2);
        Human k1=new Human("Кид1",true,15,f,m);
        Human k2=new Human("Кид2",true,15,f,m);
        Human k3=new Human("Кид3",true,15,f,m);

        System.out.println(gF1);
        System.out.println(gF2);
        System.out.println(gM1);
        System.out.println(gM2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        Human father;
        Human mother;
        int age;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
