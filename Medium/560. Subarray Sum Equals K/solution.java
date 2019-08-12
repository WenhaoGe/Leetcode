class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        int ans = 0;
        sums[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];

            if (map.containsKey(sums[i] - k)) {
                ans += map.get(sums[i] - k);
            } else {
                map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
            }
        }

        return ans;
    }
}
/**
 * sum[i]的值等于nums[0]一直加到nums[i - 1], 
 * nums[i]一直加到nums[j]的值等于sum[j + 1] minus sum[i]. 
 * K的值等于 nums[i]一直加到nums[j]的值，
 * 找出有多少个子序列使得nums[i]一直加到nums[j]的值等于K
 */
/**
 * 解法二：把每次cumulative sum都存到hashmap里面，每个key的value都是对应的频率。
 * sums[i] - sums[i'] = K, sums[i] - K = sums[i']. 
 * 每求一次cumulative sum就去map里面找是否存在sums[i'], 
 * 如果存在就把对应的频率加到ans里，如果不存在就把新的sum加到map里面
 */