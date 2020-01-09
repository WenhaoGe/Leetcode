/**
 * TC: O(n * n)
 * SC: O(1)
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return -1;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int len = nums.length - 1;
        
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (min > sum - target) {
                        min = sum - target;
                        ans = sum;
                    }
                    right--;
                } else {
                    if (min > target - sum) {
                        min = target - sum;
                        ans = sum;
                    }
                    left++;
                }
            }
        }
        
        return ans;
    }
}