package com.leetCode;

public class reverseOnlyLetters917 {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
    }
    public static String reverseOnlyLetters(String s) {
        char[] strArray = s.toCharArray();
        int i = 0, j = strArray.length - 1;
        while (i < j) {
            if (!Character.isLowerCase(strArray[i])&&!Character.isUpperCase(strArray[i])) {
                i++;
            } else if (!Character.isLowerCase(strArray[j])&&!Character.isUpperCase(strArray[j])) {
                j--;
            } else {
                char tmp = strArray[i];
                strArray[i] = strArray[j];
                strArray[j] = tmp;
                i++;
                j--;
            }
        }
        return String.valueOf(strArray);
    }
}