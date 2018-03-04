package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try (BufferedReader fis = new BufferedReader(new FileReader(br.readLine()))) {
                while (fis.ready()) {
                    String s = fis.readLine();
                    if (s.indexOf(" ") > 0)
                        if (s.substring(0, s.indexOf(" ")).equals(args[0])) {
                            System.out.println(s);
                            break;
                        }
                }
            } catch (IOException e) {
            }
        }
    }
}
