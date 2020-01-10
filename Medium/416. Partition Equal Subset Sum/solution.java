/**
 * tc: o(n * c)
 * SC: O(n * c)
 * n means the number of elements in nums array
 * c means the total sum of all the numbers.
 */

class Solution {
    public boolean canPartition(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int each: nums) {
            sum += each;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Boolean[][] arr = new Boolean[nums.length][sum / 2 + 1];
        return helper(arr, nums, sum / 2, 0);
    }
    private boolean helper(Boolean[][] arr, int[] nums, int sum, int index) {
        
        if (sum == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (arr[index][sum] == null) {
            if (sum >= nums[index]) {
                if (helper(arr, nums, sum - nums[index], index + 1)) {
                    return true;
                }
            }
            arr[index][sum] = helper(arr, nums, sum, index + 1);
        }
        return arr[index][sum];
    }
}

/**

 */

class Solution {
    public boolean canPartition(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int each: nums) {
            sum += each;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return helper(nums, sum / 2, 0);
    }
    private boolean helper(int[] nums, int sum, int index) {
        
        if (sum == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (sum >= nums[index]) {
            if (helper(nums, sum - nums[index], index + 1)) {
                return true;
            }
        }
        return helper(nums, sum, index + 1);
    }
}
