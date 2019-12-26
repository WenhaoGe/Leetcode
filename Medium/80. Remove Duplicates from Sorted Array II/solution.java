
/**
 * TC: O(n^2)
 * SC: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                
                if (count > 2) {
                    remove(nums, i);
                    i--;
                    len--;
                }
                
            } else {
                count = 1;
            }
        }
        return len;
    }
    private void remove(int[] nums, int index) {
        
        for (int i = index + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        return;
    }
}