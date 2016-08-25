package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Владимир on 03.06.2016.
 */
public class Computer {
    private Monitor monitor;
    private Keyboard keyboard;
    private Mouse mouse;

    public Computer() {
        this.monitor = new Monitor();
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
