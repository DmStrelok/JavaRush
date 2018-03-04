package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf1 = null;
        BufferedReader bf2 = null;
        try {
            String fn1 = bf.readLine();
            String fn2 = bf.readLine();
            bf1 = new BufferedReader(new FileReader(fn1));
            bf2 = new BufferedReader(new FileReader(fn2));
            while (bf1.ready()) {
                allLines.add(bf1.readLine());
            }
            while (bf2.ready()) {
                forRemoveLines.add(bf2.readLine());
            }
        }
        catch (IOException e) {}
        finally {
            try {
                bf.close();
                bf1.close();
                bf2.close();
            }
            catch (IOException e) {}
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("ffff");
        }
    }

    public void joinData () throws CorruptedDataException {
        int k = forRemoveLines.size();
        for (int i = 0; i < forRemoveLines.size(); i++) {
            if (allLines.indexOf(forRemoveLines.get(i)) != -1) k--;
            else break;
        }
        if (k == 0) {
            for (int i = 0; i < forRemoveLines.size(); i++) {
                int l;
                while ((l = allLines.indexOf(forRemoveLines.get(i))) != -1) {
                    allLines.remove(l);
                }
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
