package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    public static long cD = -1;
    public static long cF;
    public static long cC;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(br.readLine());
        if (!Files.isDirectory(path)) System.out.println(path.toString() + " - не папка");
        else {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    cD++;
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    cF++;
                    cC += Files.size(file);
                    return super.visitFile(file, attrs);
                }
            });
            System.out.println("Всего папок - " + cD);
            System.out.println("Всего файлов - " + cF);
            System.out.println("Общий размер - " + cC);
        }
    }
}
