class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int target = nums[nums.length - 1];
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] > target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l] < nums[r]) {
            return nums[l];
        } else {
            return nums[r];
        }
    }
}