package com.leetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class largestRectangleinHistogram82 {
    public static void main(String[] args) {
        int[] nu = new int[]{2,1,2};
        System.out.println(largestRectangleArea(nu));
    }
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        int len = heights.length;
        if (len == 1){
            return heights[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && heights[stack.peekLast()] <= heights[i]){
                Integer bottom = stack.removeLast();
                int area;
                int width = i - bottom;
                area = width * Math.min(heights[i],heights[bottom]);
                if (area > max){
                    max = area;
                }
            }
            stack.addLast(i);
        }
        return max;
    }
}
