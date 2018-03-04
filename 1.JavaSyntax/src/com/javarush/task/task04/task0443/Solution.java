package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int y = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int d = Integer.parseInt(bf.readLine());
        System.out.println("Меня зовут " + s + ".\nЯ родился " + d + "." + m + "." + y);

    }
}
