class Solution {
    public int maxSubArray(int[] nums) {
        int[] cumulative = new int[nums.length];

        cumulative[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cumulative[i - 1] < 0) {
                cumulative[i] = nums[i];
            } else {
                cumulative[i] = cumulative[i - 1] + nums[i];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i : cumulative) {
            if (i > ans) {
                ans = i;
            }
        }
        return ans;
    }
}