package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        try {
            Solution savedObject = new Solution(2);
            FileOutputStream fos = new FileOutputStream("D:\\Projects\\Java\\2.txt");
            ObjectOutput os = new ObjectOutputStream(fos);
            os.writeObject(savedObject);
            os.close();
            FileInputStream fis = new FileInputStream("D:\\Projects\\Java\\2.txt");
            ObjectInput oi = new ObjectInputStream(fis);
            Solution loadedObject = new Solution(0);
            loadedObject = (Solution) oi.readObject();
            oi.close();
            System.out.println(savedObject.toString());
            System.out.println(loadedObject.toString());
        }
        catch (Exception e) {}
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
