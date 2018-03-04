package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new ArrayList<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(root);
        while (priorityQueue.size() > 0) {
            File ff = new File(priorityQueue.poll());
            if (ff.listFiles().length > 0) {
                for (File file : ff.listFiles()) {
                    if (file.isFile())
                        files.add(file.getAbsolutePath());
                    else
                        priorityQueue.add(file.getAbsolutePath());
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        try {
            for (String s : getFileTree("D:\\Projects\\Java\\1")) {
                System.out.println(s);
            }
        } catch (IOException e) {
        }
    }
}
