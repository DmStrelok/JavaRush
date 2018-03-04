package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    int top, left, width, height;

    public Rectangle(Rectangle rec){
        this.top = rec.top;
        this.left = rec.left;
        this.width = rec.width;
        this.height = rec.height;
    }

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left, int width) {

        this.top = top;
        this.left = left;
        this.width = width;
    }

    public Rectangle(int top, int left) {

        this.top = top;
        this.left = left;
    }

    public static void main(String[] args) {

    }
}
