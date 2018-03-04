package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        ArrayList<String> al = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(name = br2.readLine()))) {
            while (br.ready()) {
                al.add(br.readLine());
            }
        }
        catch (IOException e) {}

        if (args.length > 0 && args[0].equals("-c")) {
            int id = 0;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
                for (int i = 0; i < al.size(); i++) {
                    bw.write(al.get(i));
                    bw.newLine();
                    if (Integer.parseInt(al.get(i).substring(0, 8).replaceAll(" ", "")) > id) id = Integer.parseInt(al.get(i).substring(0, 8).replaceAll(" ", ""));
                }

                id++;
                String s = String.valueOf(id);
                for (int i = s.length(); i < 8; i++) {
                    s = s.concat(" ");
                }
                if (s.length() > 8) s = s.substring(0, 8);

                s = s.concat(args[1]);
                for (int i = 2; i < args.length - 2; i++) {
                    s = s.concat(" ").concat(args[i]);
                }
                for (int i = s.length(); i < 38; i++) {
                    s = s.concat(" ");
                }
                if (s.length() > 38) s = s.substring(0, 38);

                s = s.concat(args[args.length - 2]);
                for (int i = s.length(); i < 46; i++) {
                    s = s.concat(" ");
                }
                if (s.length() > 46) s = s.substring(0, 46);

                s = s.concat(args[args.length - 1]);
                for (int i = s.length(); i < 50; i++) {
                    s = s.concat(" ");
                }
                if (s.length() > 50) s = s.substring(0, 50);
                bw.write(s);
            }
        }


    }
}
