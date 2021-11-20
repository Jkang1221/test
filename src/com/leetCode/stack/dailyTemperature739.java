package com.leetCode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class dailyTemperature739 {
    public static void main(String[] args) {
        int[] temperatures={30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i< len; i++){
            while (!deque.isEmpty()&&temperatures[i]>temperatures[deque.peekLast()]){
                Integer top = deque.removeLast();
                result[top] = i - top;
            }
            deque.addLast(i);
        }

        return result;
    }
}
