package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String[] strings = string.split(" ");
        if (strings.length <5) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 4; i++) {
            stringBuilder.append(strings[i]).append(" ");
        }
        stringBuilder.append(strings[4]);
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws TooShortStringException {
//       getPartOfString("JavaRush - лучший сервис обучения Java.");
        System.out.println(getPartOfString(" JavaRush - лучший сервис "));
    }

    public static class TooShortStringException extends Exception {
    }
}
