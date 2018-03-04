package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/

public class Solution {
    public static File resultFile;
    public static List<File> files = new ArrayList<>();
    
    public static void ff(File file) {
        if (file.isFile()) {
            if (file.length() > 50) FileUtils.deleteFile(file);
            else files.add(file);
            
        }
        else {
            for (File fil : file.listFiles()) {
                ff(fil);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            File path = new File(args[0]);
            File resultFileAbsolutePath = new File(args[1]);
            resultFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

            FileUtils.renameFile(resultFileAbsolutePath, resultFile);

            try (FileOutputStream fos = new FileOutputStream(resultFile)) {
                ff(path);
                files.sort(Comparator.comparing(File::getName));
               // if (files.contains(resultFile)) files.remove(resultFile);
                for (File file : files) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        while (fis.available() > 0) {
                            byte[] b = new byte[fis.available()];
                            fis.read(b);
                            fos.write(b);
                        }
                        byte[] b = "\n".getBytes();
                        fos.write(b);
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e) {
            }
        }
    }
}
