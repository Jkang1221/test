package com.leetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class trappingRainWater42 {
    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};
        System.out.println(trap(heights));
    }
    public static int trap(int[] heights) {
        int len = heights.length;
        if (len < 3) {
            return 0;
        }
        int area = 0;
        Deque<Integer> deque = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            while(!deque.isEmpty() && heights[i] >  heights[deque.peekLast()]){
                Integer bottom = deque.removeLast();
                if (deque.isEmpty()){
                    break;
                }
                int width = i - deque.peekLast() - 1;
                int curHeight = Math.min(heights[i],heights[deque.peekLast()]) - heights[bottom];
                area += width * curHeight;
            }
            deque.addLast(i);
        }
        return area;
    }
}
