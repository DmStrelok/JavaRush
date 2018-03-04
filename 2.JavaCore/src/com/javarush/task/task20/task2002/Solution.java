package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("2.txt", null, new File("D:\\Projects\\Java\\"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User u1 = new User();
            u1.setFirstName("ff");
            u1.setLastName("ll");
            u1.setBirthDate(new Date(123123123));
            u1.setMale(true);
            u1.setCountry(User.Country.RUSSIA);
            User u2 = new User();
            javaRush.users.add(u1);
            javaRush.users.add(u2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            if (users.size() < 1) pw.println("n");
            else {
                pw.println("y");
                pw.println(users.size());
                users.forEach(e -> {
                    if (e.getFirstName() == null) pw.println("n");
                    else pw.println("y\n".concat(e.getFirstName()));
                    if (e.getLastName() == null) pw.println("n");
                    else pw.println("y\n".concat(e.getLastName()));
                    if (e.getBirthDate() == null) pw.println("n");
                    else {
                        pw.println("y");
                        pw.println(e.getBirthDate().getTime());
                    }
                    pw.println(e.isMale());
                    if (e.getCountry() == null) pw.println("n");
                    else {
                        pw.println("y");
                        pw.println(e.getCountry());
                    }
                });
            }
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String s = br.readLine();
            users = new ArrayList<>();
            if (s.equals("y")) {
                int n = Integer.parseInt(br.readLine());
                for (int i = 0; i < n; i++) {
                    User u = new User();
                    if (br.readLine().equals("y")) u.setFirstName(br.readLine());
                    if (br.readLine().equals("y")) u.setLastName(br.readLine());
                    if (br.readLine().equals("y")) u.setBirthDate(new Date(Long.parseLong(br.readLine())));
                    u.setMale(Boolean.parseBoolean(br.readLine()));
                    if (br.readLine().equals("y")) {
                        s = br.readLine();
                        if (s.equals(String.valueOf(User.Country.RUSSIA))) u.setCountry(User.Country.RUSSIA);
                        else if (s.equals(String.valueOf(User.Country.UKRAINE))) u.setCountry(User.Country.UKRAINE);
                        else u.setCountry(User.Country.OTHER);
                    }
                    users.add(u);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
