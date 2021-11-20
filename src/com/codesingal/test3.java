package com.codesingal;

import java.util.ArrayList;

public class test3 {
    public static void main(String[] args) {
        int m = 4;
        int k = 10;
        int[] a = new int[]{6, 6, 4, 4, 2, 2, 1, 1};
        System.out.println(segmentsWithSum(a, m, k));

    }

    public static int segmentsWithSum(int[] a, int m, int k) {
        int len = a.length;
        int count = 0;
        for (int i = 0; i < len - m + 1; i++) {
            ArrayList temp = new ArrayList();
            for (int j = i; j < i + m; j++) {
                temp.add(a[j]);
            }
            if (calculater(temp, k)) {
                count++;
            }
        }
        return count;
    }

    private static boolean calculater(ArrayList temp, int k) {
        int len = temp.size();
        int max = (int) temp.get(0);
        int max2 = (int) temp.get(1);

        if (len == 2) {
            return max + max2 >= k;
        }
        for (int i = 2; i < len; i++) {
            if (max < (int) temp.get(i)) {
                max = (int) temp.get(i);
            } else if (max2 < (int) temp.get(i)) {
                max2 = (int) temp.get(i);
            }
        }

        return max + max2 > k;

    }
}
