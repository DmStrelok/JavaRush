package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        /*if (args.length > 1) {
            Path resultFileName = Paths.get(args[0]);
            List<String> list = new ArrayList<>();
            for (int i = 1; i < args.length; i++) {
                list.add(args[i]);
            }
            list.sort(String::compareTo);

            try {
                Path temp = Files.createTempFile(null, null);
                try (FileOutputStream fos = new FileOutputStream(temp.toString())) {
                    for (int i = 0; i < list.size(); i++) {
                        Path part = Paths.get(list.get(i));
                        Files.copy(part, fos);
                    }
                } catch (IOException e) {
                }
                try (ZipInputStream zis = new ZipInputStream(new FileInputStream(temp.toString()))) {
                    zis.getNextEntry();
                    Files.copy(zis, resultFileName);
                    zis.closeEntry();
                }
            } catch (IOException e) {
            }
        }*/

        if (args.length > 1) {
            Path resultFileName = Paths.get(args[0]);
            List<String> list = new ArrayList<>();
            for (int i = 1; i < args.length; i++) {
                list.add(args[i]);
            }
            list.sort(String::compareTo);

            try (FileOutputStream fosres = new FileOutputStream(resultFileName.toString())) {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                for (int i = 0; i < list.size(); i++) {
                    Path part = Paths.get(list.get(i));
                    Files.copy(part, baos);
                }

                try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
                    zis.getNextEntry();

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fosres.write(buffer, 0, len);
                    }

                    zis.closeEntry();
                }
            } catch (IOException e) {
            }
        }
    }
}
