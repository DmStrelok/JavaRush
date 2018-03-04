package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            Map<String, ByteArrayOutputStream> mapEntry = new HashMap<>();

            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]))) {
                ZipEntry zipEntry = zis.getNextEntry();
                while (zipEntry != null) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        baos.write(buffer, 0, len);
                    }

                    mapEntry.put(zipEntry.getName(), baos);
                    zis.closeEntry();
                    zipEntry = zis.getNextEntry();
                }
            }

            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]))) {
                Path path = Paths.get(args[0]);
                for (Map.Entry<String, ByteArrayOutputStream> z : mapEntry.entrySet()) {
                    System.out.println(z.getKey() + (" new/" + path.getFileName()).toLowerCase());
                    if (z.getKey().toLowerCase().equals(("new/" + path.getFileName()).toLowerCase())) continue;
                    zos.putNextEntry(new ZipEntry(z.getKey()));

                    byte[] buffer = new byte[1024];
                    int len;
                    ByteArrayInputStream bais = new ByteArrayInputStream(z.getValue().toByteArray());
                    while ((len = bais.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }

                    zos.closeEntry();
                }
                zos.putNextEntry(new ZipEntry("new/" + path.getFileName()));
                Files.copy(path, zos);
                zos.closeEntry();
            }
        }
    }
}
