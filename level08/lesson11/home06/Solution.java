package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> child =new ArrayList<>();
        Human child1 = new Human("Child1", true, 15, child);
        Human child2 = new Human("Child2", false, 10, child);
        Human child3 = new Human("Child3", true, 5, child);

        ArrayList<Human> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human parentFather = new Human("Father", true, 40, children);
        Human parentMother = new Human("Mother", false, 30, children);

        ArrayList<Human> father = new ArrayList<>();
        father.add(parentFather);

        ArrayList<Human> mother = new ArrayList<>();
        mother.add(parentMother);

        Human grandFather1 = new Human("Grandfather1", true, 80, father);
        Human grandMother1 = new Human("Grandmother1", false, 75, father);

        Human grandFather2 = new Human("Grandfather2", true, 85, mother);
        Human grandMother2 = new Human("Grandmother1", false, 70, mother);

        ArrayList<Human> family=new ArrayList<>();
        family.add(grandFather1);
        family.add(grandFather2);
        family.add(grandMother1);
        family.add(grandMother2);
        family.add(parentFather);
        family.add(parentMother);
        family.add(child1);
        family.add(child2);
        family.add(child3);
        for (Human human : family) {
            System.out.println(human);
        }





    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        /*public Human(String name, boolean sex, int age){
            this.name=name;
            this.sex=sex;
            this.age=age;
        }*/

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
