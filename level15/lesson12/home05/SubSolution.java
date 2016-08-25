package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Vladimir on 05.08.2016.
 */
public class SubSolution extends Solution
{

    public SubSolution(String s)
    {
        super(s);
    }

    public SubSolution(int i)
    {
        super(i);
    }

    public SubSolution(boolean b)
    {
        super(b);
    }

    protected SubSolution(String s, String st)
    {
        super(s, st);
    }

    protected SubSolution(int i, int x)
    {
        super(i, x);
    }

    protected SubSolution(boolean b, boolean q)
    {
        super(b, q);
    }

    SubSolution(short s)
    {
        super(s);
    }

    SubSolution(float f)
    {
        super(f);
    }

    SubSolution(double d)
    {
        super(d);
    }

    private SubSolution(Integer i){super(i);}
    private SubSolution(Float i){super(i);}
    private SubSolution(Short i){super(i);}
}
