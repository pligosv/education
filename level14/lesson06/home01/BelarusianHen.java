package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Vladimir on 02.06.2016.
 */
public class BelarusianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 40;
    }
    @Override
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц";
    }
}
