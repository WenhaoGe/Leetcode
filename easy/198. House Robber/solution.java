
//f(k) = max(robs(k – 2) + nums[i - 1], f(k – 1))
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
        int len = nums.length;
        int[] robs = new int[len + 1];
        robs[0] = 0;
        robs[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            robs[i] = Math.max(robs[i - 2] + nums[i - 1], robs[i - 1]);
        }

        int ans = 0;
        for (int rob : robs) {
            if (rob > ans) {
                ans = rob;
            }
        }
        return ans;
    }
}