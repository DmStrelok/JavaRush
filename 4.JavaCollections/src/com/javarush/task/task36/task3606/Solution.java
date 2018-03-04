package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File files = new File(packageName);
        ClazzLoader clazzLoader = new ClazzLoader();
        for (File file : Objects.requireNonNull(files.listFiles())) {
            if (file.getName().lastIndexOf(".class") == file.getName().length() - 6) {
                try {
                    hiddenClasses.add(clazzLoader.load(file.toPath()));
                } catch (IOException ignored) {
                }
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().indexOf(key.toLowerCase()) == 0) {
                try {
                    for (Constructor constructor : clazz.getDeclaredConstructors()) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance();
                        }
                    }
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                }
            }
        }
        return null;
    }

    public static class ClazzLoader extends ClassLoader {
        public Class load(Path path) throws IOException {
            byte[] b = Files.readAllBytes(path);
            return defineClass(null, b, 0, b.length);
        }
    }
}

