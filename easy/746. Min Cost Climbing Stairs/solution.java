class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        return helper(cost, 0);
    }
    private int helper(int[] cost, int index) {
        
        
        if (index >= cost.length) {
            return 0;
        }
        int fee1 = helper(cost, index + 1);
        int fee2 = helper(cost, index + 2);
        int min = Math.min(fee1, fee2);
        
        return cost[index] + min;
    }
}