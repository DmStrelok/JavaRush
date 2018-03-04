package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*List<String> list = new ArrayList<>();
        list.add("(-2)^(-2)");
        list.add("89-cos(180)^2");
        list.add("sin(2*(-5+1.5*4)+28)");
        list.add("tan(45)");
        list.add("tan(-45)");
        list.add("0.305");
        list.add("0.3051");
        list.add("(0.3051)");
        list.add("1+(1+(1+1)*(1+1))*(1+1)+1");
        list.add("tan(44+sin(89-cos(180)^2))");
        list.add("-2+(-2+(-2)-2*(2+2))");
        list.add("sin(80+(2+(1+1))*(1+1)+2)");
        list.add("1+4/2/2+2^2+2*2-2^(2-1+1)");
        list.add("2^10+2^(5+5)");
        list.add("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1");
        list.add("0.000025+0.000012");
        list.add("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)");
        list.add("cos(3 + 19*3)");
        list.add("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)");
        list.add("(-1 + (-2))");
        list.add("-sin(2*(-5+1.5*4)+28)");
        list.add("sin(100)-sin(100)");
        list.add("-(-22+22*2)");
        list.add("-2^(-2)");
        list.add("-(-2^(-2))+2+(-(-2^(-2)))");
        list.add("(-2)*(-2)");
        list.add("(-2)/(-2)");
        list.add("sin(-30)");
        list.add("cos(-30)");
        list.add("tan(-30)");
        list.add("2+8*(9/4-1.5)^(1+1)");
        list.add("0.005");
        list.add("0.0049");
        list.add("0+0.304");
        *//*(-2)^(-2) expected output 0.25 3 actually 0.25 3
        89-cos(180)^2 expected output 88 3 actually 88 3
        sin(2*(-5+1.5*4)+28) expected output 0.5 6 actually 0.5 6
        tan(45) expected output 1 1 actually 1 1
        tan(-45) expected output -1 2 actually -1 2
        0.305 expected output 0.3 0 actually 0.3 0
        0.3051 expected output 0.31 0 actually 0.31 0
        (0.3051) expected output 0.31 0 actually 0.31 0
        1+(1+(1+1)*(1+1))*(1+1)+1 expected output 12 8 actually 12 8
        tan(44+sin(89-cos(180)^2)) expected output 1 6 actually 1 6
        -2+(-2+(-2)-2*(2+2)) expected output -14 8 actually -14 8
        sin(80+(2+(1+1))*(1+1)+2) expected output 1 7 actually 1 7
        1+4/2/2+2^2+2*2-2^(2-1+1) expected output 6 11 actually 6 11
        2^10+2^(5+5) expected output 2048 4 actually 2048 4
        1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1 expected output 72.96 8 actually 72.96 8
        0.000025+0.000012 expected output 0 1 actually 0 1
        -2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2) expected output -3 16 actually -3 16
        cos(3 + 19*3) expected output 0.5 3 actually 0.5 3
        2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547) expected output 8302231.36 14 actually 8302231.36 14
        (-1 + (-2)) expected output -3 3 actually -3 3
        -sin(2*(-5+1.5*4)+28) expected output -0.5 7 actually -0.5 7
        sin(100)-sin(100) expected output 0 3 actually 0 3
        -(-22+22*2) expected output -22 4 actually -22 4
        -2^(-2) expected output -0.25 3 actually -0.25 3
        -(-2^(-2))+2+(-(-2^(-2))) expected output 2.5 10 actually 2.5 10
        (-2)*(-2) expected output 4 3 actually 4 3
        (-2)/(-2) expected output 1 3 actually 1 3
        sin(-30) expected output -0.5 2 actually -0.5 2
        cos(-30) expected output 0.87 2 actually 0.87 2
        tan(-30) expected output -0.58 2 actually -0.58 2
        2+8*(9/4-1.5)^(1+1) expected output 6.5 6 actually 6.48 6
        0.005  expected output 0.01 0 actually 0.01 0
        0.0049  expected output 0 0 actually 0 0
        0+0.304 expected output 0.3 1 actually 0.3 1*//*

        solution.recursion("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0); //expected output 0.5 6
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "   ====   ");
            solution.recursion(list.get(i), 0);
        }*/
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        Locale.setDefault(Locale.ENGLISH);
        String s = expression;
        if (countOperation == 0) {
            s = expression.replaceAll(" ", "").toLowerCase();
            int i = 0;
            String o = "+-*/^ict";
            for (int j = 0; j < s.length(); j++) {
                if (o.contains(String.valueOf(s.charAt(j)))) i++;
            }
            countOperation = i;
            if (i == 0) countOperation = -1;
            StringBuilder s2 = new StringBuilder("");
            Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
            Matcher matcher = pattern.matcher(s);
            int r = 0;
            if (matcher.find()) {
                r = matcher.end();
                try {
                    s2.append(s.substring(0, matcher.start()));
                } catch (Exception e) {}
                s2.append("+");
                if (matcher.group().indexOf("-") == 0) s2.append("-+").append(matcher.group().substring(1));
                else s2.append(matcher.group());
            }
            while (matcher.find()) {
                int r2 = matcher.start();
                if (r != r2) s2.append(s.substring(r, r2));
                r = matcher.end();
                s2.append("+");
                if (matcher.group().indexOf("-") == 0) s2.append("-+").append(matcher.group().substring(1));
                else s2.append(matcher.group());
            }
            if (r != s.length()) s2.append(s.substring(r));
            s = s2.toString();
        }

        String s2 = s;
        int n = s.lastIndexOf("(");
        int k = s.length();
        if (n >= 0) {
            k = s.indexOf(")", n);
            s2 = s.substring(n + 1, k);
            String s3 = s2;
            if (s2.indexOf("+-") == 0 || s2.indexOf("++") == 0) s2 = s2.substring(1);
            if (s2.indexOf("-+") == 0) s2 = "-" + s2.substring(2);
            if (s2.indexOf("--") == 0) s2 = "+" + s2.substring(2);
            Pattern pattern = Pattern.compile("^[+|-]?\\d+\\.?\\d*?$");
            Matcher matcher = pattern.matcher(s2);
            if (matcher.find()) {
                Double d = Double.parseDouble(matcher.group(0).replace("+-", "-"));
                s = s.substring(0, n) + (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d) + s.substring(k + 1);
                recursion(s, countOperation);
                return;
            }
            s2 = s3;
        }

        Pattern pattern = Pattern.compile("sin[+|-]?\\d+\\.?\\d*$?");
        Matcher matcher = pattern.matcher(s2);
        if (matcher.find()) {
            String s3 = matcher.group(0);
            Double d = Double.parseDouble(s3.substring(3, s3.length()));
            d = Math.sin(Math.toRadians(d));
            int na = matcher.start();
            int ka = matcher.end();
            String sa = "";
            if (na > 0) sa = s2.substring(0, na);
            sa += (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d);
            if (ka < s2.length()) sa += s2.substring(ka);
            s2 = "";
            if (n >= 0) s2 = s.substring(0, n + 1);
            s2 = s2 + sa;
            if (k < s.length()) s2 = s2 + s.substring(k);
            recursion(s2, countOperation);
            return;
        }

        pattern = Pattern.compile("cos[+|-]?\\d+\\.?\\d*$?");
        matcher = pattern.matcher(s2);
        if (matcher.find()) {
            String s3 = matcher.group(0);
            Double d = Double.parseDouble(s3.substring(3, s3.length()));
            d = Math.cos(Math.toRadians(d));
            int na = matcher.start();
            int ka = matcher.end();
            String sa = "";
            if (na > 0) sa = s2.substring(0, na);
            sa += (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d);
            if (ka < s2.length()) sa += s2.substring(ka);
            s2 = "";
            if (n >= 0) s2 = s.substring(0, n + 1);
            s2 = s2 + sa;
            if (k < s.length()) s2 = s2 + s.substring(k);
            recursion(s2, countOperation);
            return;
        }

        pattern = Pattern.compile("tan[+|-]?\\d+\\.?\\d*$?");
        matcher = pattern.matcher(s2);
        if (matcher.find()) {
            String s3 = matcher.group(0);
            Double d = Double.parseDouble(s3.substring(3, s3.length()));
            d = Math.tan(Math.toRadians(d));
            int na = matcher.start();
            int ka = matcher.end();
            String sa = "";
            if (na > 0) sa = s2.substring(0, na);
            sa += (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d);
            if (ka < s2.length()) sa += s2.substring(ka);
            s2 = "";
            if (n >= 0) s2 = s.substring(0, n + 1);
            s2 = s2 + sa;
            if (k < s.length()) s2 = s2 + s.substring(k);
            recursion(s2, countOperation);
            return;
        }

        pattern = Pattern.compile("[+|-]?\\d+\\.?\\d*\\^[+|-]?\\d+\\.?\\d*");
        matcher = pattern.matcher(s2);
        if (matcher.find()) {
            String s3 = matcher.group(0);

            String[] sg = s3.split("\\^");
            Double d = Double.parseDouble(sg[0]);
            Double d2 = Double.parseDouble(sg[1]);
            d = Math.pow(d, d2);

            int na = matcher.start();
            int ka = matcher.end();
            String sa = "";
            if (na > 0) sa = s2.substring(0, na);
            sa += (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d);
            if (ka < s2.length()) sa += s2.substring(ka);
            s2 = "";
            if (n >= 0) s2 = s.substring(0, n + 1);
            s2 = s2 + sa;
            if (k < s.length()) s2 = s2 + s.substring(k);
            recursion(s2, countOperation);
            return;
        }

        if (s2.indexOf("+-") == 0 || s2.indexOf("++") == 0) s2 = s2.substring(1);
        if (s2.indexOf("-+") == 0) s2 = "-" + s2.substring(2);
        s2 = s2.replace("--", "++");
        s2 = s2.replace("-+", "+-");
        s2 = s2.replace("++-", "+-");

        pattern = Pattern.compile("[+|-]?\\d+\\.?\\d*/[+|-]?\\d+\\.?\\d*");
        matcher = pattern.matcher(s2);
        if (matcher.find()) {
            String s3 = matcher.group(0);

            String[] sg = s3.split("/");
            Double d = Double.parseDouble(sg[0]);
            Double d2 = Double.parseDouble(sg[1]);
            d /= d2;

            int na = matcher.start();
            int ka = matcher.end();
            String sa = "";
            if (na > 0) sa = s2.substring(0, na);
            sa += (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d);
            if (ka < s2.length()) sa += s2.substring(ka);
            s2 = "";
            if (n >= 0) s2 = s.substring(0, n + 1);
            s2 = s2 + sa;
            if (k < s.length()) s2 = s2 + s.substring(k);
            recursion(s2, countOperation);
            return;
        }

        pattern = Pattern.compile("[+|-]?\\d+\\.?\\d*\\*[+|-]?\\d+\\.?\\d*");
        matcher = pattern.matcher(s2);
        if (matcher.find()) {
            String s3 = matcher.group(0);

            String[] sg = s3.split("\\*");
            Double d = Double.parseDouble(sg[0]);
            Double d2 = Double.parseDouble(sg[1]);
            d *= d2;

            int na = matcher.start();
            int ka = matcher.end();
            String sa = "";
            if (na > 0) sa = s2.substring(0, na);
            sa += (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d);
            if (ka < s2.length()) sa += s2.substring(ka);
            s2 = "";
            if (n >= 0) s2 = s.substring(0, n + 1);
            s2 = s2 + sa;
            if (k < s.length()) s2 = s2 + s.substring(k);
            recursion(s2, countOperation);
            return;
        }

        pattern = Pattern.compile("[+|-]?\\d+\\.?\\d*\\+[+|-]?\\d+\\.?\\d*");
        matcher = pattern.matcher(s2);
        if (matcher.find()) {
            String s3 = matcher.group(0);
            String[] sg = s3.split("\\+");
            if (sg[0].equals("")) {
                sg[0] = sg[1];
                sg[1] = sg[2];
                if (sg.length > 3) sg[2] = sg[3];
            }
            if (sg[1].equals("")) {
                sg[1] = sg[2];
            }
            Double d = Double.parseDouble(sg[0]);
            Double d2 = Double.parseDouble(sg[1]);
            d += d2;

            int na = matcher.start();
            int ka = matcher.end();
            String sa = "";
            if (na > 0) sa = s2.substring(0, na);
            sa += (d > 0 ? "+" : "") + new DecimalFormat("#.##").format(d);
            if (ka < s2.length()) sa += s2.substring(ka);
            s2 = "";
            if (n >= 0) s2 = s.substring(0, n + 1);
            s2 = s2 + sa;
            if (k < s.length()) s2 = s2 + s.substring(k);
            recursion(s2, countOperation);
            return;
        }


        Double res = Double.parseDouble(s2);
        if (countOperation == -1) countOperation = 0;
        System.out.println(new DecimalFormat("#.##").format(res) + " " + countOperation);
    }

    public Solution() {
        //don't delete
    }
}
