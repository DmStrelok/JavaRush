package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), clazz);
    }

    public static void main(String[] args) {

    }

   /* public static void main(String[] args) {
        try {
            System.out.println(convertFromJsonToNormal("D:\\Projects\\Java\\Tests\\2.txt", Cat.class));
        } catch (IOException e) {
        }
    }

    @JsonAutoDetect
    public static class Cat {

        @JsonProperty("wildAnimal")
        public String name;

        @JsonIgnore
        public int age;

        @JsonProperty("over")
        public int weight;

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }

        Cat() {
        }
    }*/
}
