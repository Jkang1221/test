package com.codesingal;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
        String sequence = "dabcacab";
        String[] words = new String[]{"ab", "" };
        maxKOccurrences(sequence, words);
    }

    public static int[] maxKOccurrences(String sequence, String[] words) {
        int len = words.length;
        int[] res = new int[len];
        char[] ch = sequence.toCharArray();
        for (int i = 0; i < len; i++) {
            if (words[i] == "") {
                res[i] = 0;
            } else {
                res[i] = find(sequence, words[i]);
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    private static int find(String s, String word) {
        int chLen = s.length();
        int count = 0;
        int wordLen = word.length();
        int j = 0;
        if (s.length() < word.length()) {
            return 0;
        }
        for (int i = 0; i < chLen - wordLen + 1; i++) {
            String temp = s.substring(i, i + wordLen);
            if (temp.equals(word) && count == 0) {
                count++;
                j = i;
            } else if (temp.equals(word) && i == j + wordLen) {
                count++;
                j = i;
            }
        }

        return count;
    }
}
