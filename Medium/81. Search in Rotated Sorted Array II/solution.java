/**
 * 思路：
 * The only difference is that due to the existence of duplicates, 
 * we can have nums[left] == nums[mid] and in that case, 
 * the first half could be out of order (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) 
 * and we have to deal this case separately. 
 * In that case, it is guaranteed that nums[right] also equals to nums[mid], 
 * so what we can do is to check if nums[mid]== nums[left] == nums[right] before the original logic, 
 * and if so, we can move left and right both towards the middle by 1. 
 * and repeat.
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        //当数组
        if(nums.length == 0 || nums == null) {return false;}
        if(nums.length == 1 && nums[0] == target) {return true;}
        if(nums.length == 2) {
            if(nums[0] == target || nums[1] == target) {return true;}
        }
        while(l + 1 < r) {
            int mid = l + (r - l)/2;
            if(nums[mid] == target) {return true;}
             // the only difference from the first one, trickly case, just updat left and right
            if(nums[mid] == nums[l] && nums[mid] == nums[r]) {
                l++;
                r--;
            }
            else if(nums[l] <= nums[mid]) {
                if(target >= nums[l] && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if(target >= nums[mid] && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        } 
        if(nums[l] == target || nums[r] == target) {return true;}
        return false;
    }
}