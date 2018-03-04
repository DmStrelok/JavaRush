package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(br.readLine());
            while (fis.available() > 999) {
                fis.close();
                fis = new FileInputStream(br.readLine());
            }
        }
        catch (Exception e) {}
        finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
            }
            throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}
