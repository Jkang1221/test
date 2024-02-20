package com.leetCode.array;

public class RotateArray189 {
  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3, 4};
    rotate(array, 2);
  }

  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    for (int i = n - k - 1; i >= 0; i--) {
      int move = nums[i];
      for (int j = i; j < i + k; j++) {
        nums[j] = nums[j + 1];
      }
      nums[i + k] = move;
    }
  }
}
