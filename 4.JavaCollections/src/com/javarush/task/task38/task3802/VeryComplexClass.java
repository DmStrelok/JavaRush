package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        (new BufferedReader(new FileReader(new File("ff")))).readLine();
    }

    public static void main(String[] args) {

    }
}
