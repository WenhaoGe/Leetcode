class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {

                int j = i + 1;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                }
                int number = j - i;
                ans = Math.max(ans, number);
                i = j;
            } else {
                i++;
            }
        }
        return ans;
    }
}