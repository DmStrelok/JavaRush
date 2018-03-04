package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        File file = new File(pathToAnimals);
        Set<Animal> set = new HashSet<>();
        ClazzLoader clazzLoader = new ClazzLoader();
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isFile() && f.getName().lastIndexOf(".class") == f.getName().length() - 6) {
                    try {
                        Class clazz = clazzLoader.load(f.toPath());
                        boolean b = false;
                        if (Animal.class.isAssignableFrom(clazz)) b = true;
                        if (b) {
                            Constructor[] constructors = clazz.getConstructors();
                            for (int i = 0; i < constructors.length; i++) {
                                if (constructors[i].getParameterTypes().length == 0) {
                                    set.add((Animal) constructors[i].newInstance());
                                    break;
                                }
                            }
                        }
                    } catch (IOException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    }
                }
            }
        }

        return set;
    }

    public static class ClazzLoader extends ClassLoader {
        public Class load(Path path) throws IOException {
            byte[] b = Files.readAllBytes(path);
            return defineClass(null, b, 0, b.length);
        }
    }
}
