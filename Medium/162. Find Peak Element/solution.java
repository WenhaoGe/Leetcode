class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid - 1]) {
                l = mid;
            } else if (nums[mid - 1] > nums[mid]) {
                r = mid;
            }
        }
        if (nums[l] < nums[r]) {
            return r;
        } else {
            return l;
        }
    }
}

/**
 * 用二分搜索。先把中间值找出来，拿它和前后两个值比比。 如果中间值处于上升阶段，说明峰值在中间值后面。 如果中间值处于下降阶段，说明峰值在中间值前面。
 * 循环结束以后，比一下剩下的两个值谁大，return大的那个
 */