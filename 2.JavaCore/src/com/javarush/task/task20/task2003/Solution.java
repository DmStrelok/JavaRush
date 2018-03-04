package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            FileInputStream fis = new FileInputStream(br.readLine());
            load(fis);
        } catch (IOException e) {} catch (Exception e) {}
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        Solution.properties.entrySet().forEach(e -> {
            properties.setProperty(e.getKey(), e.getValue());
        });
        properties.store(outputStream, "com");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        properties.load(inputStream);
        Solution.properties = new HashMap<>();
        for (String name: properties.stringPropertyNames())
            Solution.properties.put(name, properties.getProperty(name));
    }

    public static void main(String[] args) {
        Solution.properties.put("a1", "b1");
        Solution.properties.put("a2", "b2");
        Solution.properties.put("a3", "b3");
        Solution.properties.put("a4", "b4");
        Solution s = new Solution();
        try {
            s.save(new FileOutputStream("D:\\Projects\\Java\\2.txt"));
        } catch (Exception e) {}

        try {
            s.load(new FileInputStream("D:\\Projects\\Java\\2.txt"));
        } catch (Exception e) {}
    }
}
