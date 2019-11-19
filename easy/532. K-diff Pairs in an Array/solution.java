class Solution {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}

/**
 * Solution 2
 */

class Solution {
    public int findPairs(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) {
                    ans++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}