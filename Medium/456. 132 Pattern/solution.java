class Solution {
    public boolean find132pattern(int[] nums) {
        
        int len = nums.length;
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < len - 1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < len; k++) {
                if (nums[j] > nums[k] && nums[k] > min_i) {
                    return true;
                }
            }
        }
        return false;
    }
}