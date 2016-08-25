package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Vladimir on 02.06.2016.
 */
/*
В каждом из четырех последних классов написать свою реализацию метода getDescription.
        Методы должны возвращать строку вида:
<getDescription() родительского класса>  + <" Моя страна - Sssss. Я несу N яиц в месяц.">
        где Sssss - название страны
        где N - количество яиц в месяц*/
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth(){return 10;}

    @Override
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц";
    }
}
