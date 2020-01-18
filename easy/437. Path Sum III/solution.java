
/**
 * TC: O(n)
 * SC: O(k)
 */

class Solution {
    public int pathSum(TreeNode root, int sum) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, 0, sum, map);
        return count;
    }
    int count = 0;
    public void dfs(TreeNode root, int current, int target, Map<Integer, Integer> map) {
        
        if (root == null) {
            return;
        }
        current += root.val;
        if (map.containsKey(current - target)) {
            count += map.get(current - target);
        }
        map.put(current, map.getOrDefault(current, 0) + 1);
        
        dfs(root.left, current, target, map);
        dfs(root.right, current, target, map);
        map.put(current, map.get(current) - 1);
    }
}