package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        //напишите тут ваш код
        String numd = "0123456789abcdef";
        String num = number.getDigit();
        for (int i = 0; i < num.length(); i++) {
            if (numd.indexOf(num.charAt(i)) == -1 || numd.indexOf(num.charAt(i)) >= number.getNumerationSystem().getNumerationSystemIntValue())
                throw new NumberFormatException();
        }
        BigInteger dig = BigInteger.valueOf(0);
        BigInteger pow = BigInteger.valueOf(1);
        for (int i = num.length() - 1; i >=0; i--) {
            dig = dig.add(BigInteger.valueOf(numd.indexOf(num.charAt(i))).multiply(pow));
            pow = pow.multiply(BigInteger.valueOf(number.getNumerationSystem().getNumerationSystemIntValue()));
        }
        StringBuilder sb = new StringBuilder("");
        while (dig.compareTo(BigInteger.valueOf(0)) > 0) {
            int b = Integer.parseInt(dig.mod(BigInteger.valueOf(expectedNumerationSystem.getNumerationSystemIntValue())).toString());
            dig = dig.divide(BigInteger.valueOf(expectedNumerationSystem.getNumerationSystemIntValue()));
            sb.append(numd.charAt(b));
        }
        sb.reverse();
        return new Number(expectedNumerationSystem, sb.toString());
    }
}
