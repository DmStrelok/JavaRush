package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        ArrayList<String> al = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(name = br2.readLine()))) {
            while (br.ready()) {
                al.add(br.readLine());
            }
        } catch (IOException e) {
        }

        if (args.length > 0 && args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
                for (int i = 0; i < al.size(); i++) {
                    if (Integer.parseInt(al.get(i).substring(0, 8).replaceAll(" ", "")) != id) {
                        bw.write(al.get(i));
                        bw.newLine();
                    }
                }
            }
            catch (IOException e) {}
        }

        if (args.length > 0 && args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
                for (int i = 0; i < al.size(); i++) {
                    if (Integer.parseInt(al.get(i).substring(0, 8).replaceAll(" ", "")) == id) {
                        String s = String.valueOf(id);
                        for (int j = s.length(); j < 8; j++) {
                            s = s.concat(" ");
                        }
                        if (s.length() > 8) s = s.substring(0, 8);

                        s = s.concat(args[2]);
                        for (int j = 3; j < args.length - 2; j++) {
                            s = s.concat(" ").concat(args[j]);
                        }
                        for (int j = s.length(); j < 38; j++) {
                            s = s.concat(" ");
                        }
                        if (s.length() > 38) s = s.substring(0, 38);

                        s = s.concat(String.format("%-8s", args[args.length - 2]).substring(0, 8));
                        s = s.concat(String.format("%-4s", args[args.length - 1]).substring(0, 4));

                        al.set(i, s);
                    }
                    bw.write(al.get(i));
                    bw.newLine();
                }
            }
            catch (IOException e) {}
        }

    }
}
