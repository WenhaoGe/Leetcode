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

/**
 * solution 2
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        
        int cost1 = cost[0];
        int cost2 = cost[1];
        int current = 0;
        for (int i = 2; i < cost.length; i++) {
            current = cost[i] + Math.min(cost1, cost2);
            cost1 = cost2;
            cost2 = current;
        }
        return Math.min(cost1, cost2);
    }
}