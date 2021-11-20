package com.leetCode;

public class sqrtX69 {
    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        System.out.println(solution69.mySqrt(8));
    }
}
class Solution69 {
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int left = 0;
        int right = x/2;
        while(left < right){
            int mid = (right - left +1)/2 + left;
            if(mid == x /mid){
                return mid;
            }else if (mid > x/mid){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;
    }
}