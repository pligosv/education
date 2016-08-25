package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Vladimir on 02.06.2016.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth(){return 20;}
    @Override
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц";
    }
}
