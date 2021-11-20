package com.classic75.Binary;

import java.util.Arrays;

public class countingBits338 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(countBits2(2)));
        System.out.println(Arrays.toString(countBits3(7)));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = fintBit(i);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static int fintBit(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /*动态规划一：
    * i&(i-1)：得到最后一个1去掉的数值含有1的数量。
    * +1：加上去掉的那个1，得到res[i]所包含1的数量。
    * */
    public static int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
    /*动态规划二：
    * i>>1:把当前的n缩小两倍，即向右移动一位
    * res[i>>1]:得到当前的数值1的个数
    * i&1:等价于求i除以二的余数，来判断奇偶书
    *
    * */
    public static int[] countBits3(int n){
        int[] res = new int[n+1];
        for (int i = 1;i<=n;i++){
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }
}
