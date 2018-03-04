package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = bf.readLine();
            secondFileName = bf.readLine();
        }
        catch (IOException e) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String s;
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return s;
        }

        @Override
        public void run() {
            BufferedReader fr = null;
            s = "";
            try {
                fr = new BufferedReader(new FileReader(fullFileName));
                while (fr.ready()) {
                    s = s.concat(fr.readLine()).concat(" ");
                }
            } catch (IOException e) {
            }
            finally {
                try {
                    fr.close();
                } catch (IOException e) {
                }
            }
        }
    }
    //add your code here - добавьте код тут
}
