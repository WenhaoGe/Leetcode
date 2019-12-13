class Solution {
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int res1 = helper(nums, 0, nums.length - 2);
        int res2 = helper(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }
    private int helper(int[] nums, int start, int end) {
        
        if (start == end) {
            return nums[start];
        }
        if (start + 1 == end) {
            return Math.max(nums[start], nums[end]);
        }
        int[] copy = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            copy[i] = nums[start++];
        }
        int[] dp = new int[copy.length + 1];
        dp[0] = 0;
        dp[1] = copy[0];
        dp[2] = Math.max(copy[0], copy[1]);
        for (int i = 3; i <= copy.length; i++) {
            dp[i] = Math.max(dp[i - 1], (dp[i - 2] + copy[i - 1]));
        }
        return dp[copy.length];
    }
}