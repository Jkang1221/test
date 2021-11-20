/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
@SuppressWarnings({"all"})
class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peak = findPeakMountain(mountainArr,len);
        int countLeft = findLeft(target,mountainArr,peak);
        if(countLeft >= 0){
            return countLeft;
        }else{
            int countRight = findRight(target,mountainArr,peak,len);
            return countRight;
        }
    }
    public int findPeakMountain(MountainArray mountainArr,int len){
        int left = 0, right = len - 1;
        while(left < right){
            int mid = (right - left)/2 + left;
            int midNum = mountainArr.get(mid);
            int midLeft = mountainArr.get(mid-1);
            int midRight = mountainArr.get(mid+1);
            if(midRight < midNum && midLeft < midNum ){
                return mid;
            }else if(midRight > midNum){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public int findLeft(int target, MountainArray mountainArr,int peak){
        int left = 0, right = peak;
        while(left <right){
            int mid = (right-left)/2 + left;
            if(target > mountainArr.get(mid)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if(mountainArr.get(left) == target){
            return left;
        }
        return -1;
    }
    public int findRight(int target, MountainArray mountainArr,int peak, int len){
        int left = peak,right = len -1;
        while(left < right){
            int mid = (right-left)/2 + left;
            if(target < mountainArr.get(mid)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if(mountainArr.get(left)==target){
            return left;
        }
        return -1;
    }
}
class MountainArray{
    public int get(int nums){
        return -1;
    }
    public int length(){
        return -1;
    }
}