package com.leetCode.array;

import java.util.Arrays;

public class Hindex274 {
  public static void main(String[] args) {
    int[] array = new int[] {3, 0, 6, 1, 5};
    hIndex(array);
  }

  public static int hIndex(int[] citations) {
    //    Collections.sort(citations);
    Arrays.sort(citations);
    //    Arrays.sort(citations, (o1, o2) -> o2 - o1);
    //    System.out.println(Arrays.toString(citations));
    return 1;
  }
}
