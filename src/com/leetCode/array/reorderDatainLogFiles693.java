package com.leetCode.array;

import java.util.Arrays;

public class reorderDatainLogFiles693 {
  public static void main(String[] args) {
    //    String[] logs = new String(){,"let1 art can","dig2 3 6","let2 own kit dig","let3 art
    // zero"};
    //        String a = "dig1 8 1 5 1";
    //        String b = "let1 art can";
    //        String[] split1 = a.split(" ", 2);
    //        String[] as = a.split(" ",2);
    //        System.out.println(Arrays.toString(split1));
    Integer[] temp = new Integer[] {3, 1, 2};

    Arrays.sort(
        temp,
        (a, b) -> {
          if (a > b) {
            return -1;
          } else {
            return 1;
          }
        });
    System.out.println(Arrays.toString(temp));
  }

  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(
        logs,
        (a, b) -> {
          String[] as = a.split(" ", 2);
          String[] bs = b.split(" ", 2);

          Boolean isDigitA = Character.isDigit(as[1].charAt(0));
          Boolean isDigitB = Character.isDigit(bs[1].charAt(0));

          if (isDigitA && !isDigitB) {
            return -1;
          } else if (!isDigitA && isDigitB) {
            return 1;
          } else if (isDigitA && isDigitB) {
            return 0;
          } else {
            if (!as[1].equals(bs[1])) {
              return as[1].compareTo(bs[1]);
            } else {
              return as[0].compareTo(bs[0]);
            }
          }
        });
    return logs;
  }
}
