package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution(String s){}
    public Solution(int i){}
    public Solution(boolean b){}

    protected Solution(String s, String st){}
    protected Solution(int i, int x){}
    protected Solution(boolean b, boolean q){}

    Solution(short s){}
    Solution(float f){}
    Solution(double d){}

    private Solution(Integer i){}
    private Solution(Float i){}
    private Solution(Short i){}
}

