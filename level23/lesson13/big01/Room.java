package com.javarush.test.level23.lesson13.big01;

public class Room {

    public static Room game;

    private int width;
    private int height;

    private static Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;

        createMouse();
        run();
    }

    public static void main(String[] args) {
        snake = new Snake(1, 1);
        game = new Room(10, 10, snake);
        snake.setDirection(SnakeDirection.DOWN);
    }

    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        mouse = new Mouse(x, y);
    }

    public void eatMouse() {
        createMouse();
    }

    public void sleep(){
        int time = snake.getSections().size() == 0 ? 500 : 500 - snake.getSections().size() * 5;
        try {
            Thread.sleep(snake.getSections().size() < 10 ? time : 200);
        }
        catch (InterruptedException e) {
        }
    }

    public void run() {
    }

    public void print() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
