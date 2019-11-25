class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[left]) { // right part of the array is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // target is on the left part
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // left part of the array is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}