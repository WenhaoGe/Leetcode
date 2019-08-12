class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        int[] ans = new int[nums.length];
        lefts[0] = 1;
        for (int i = 1; i < nums.length; i++) {

            lefts[i] = lefts[i - 1] * nums[i - 1];

        }
        rights[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rights[i] = rights[i + 1] * nums[i + 1];

        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = lefts[i] * rights[i];
        }
        return ans;
    }
}

/**
 * created two arrays, lefts and rights. 
 * Let’s fill the empty with 1:
 * Numbers:     2    3    4     5
 * Lefts:       1    2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5     1
 * We can calculate lefts and rights in 2 loops. The time complexity is O(n).
 * ans[i] = lefts[i] *rights[i];   i++
 */