/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        dfs(root, ans);
        return ans[0];
    }

    private int dfs(TreeNode root, int[] ans) {
        int left = root.left != null ? Math.max(dfs(root.left, ans), 0) : 0;
        int right = root.right != null ? Math.max(dfs(root.right, ans), 0) : 0;

        int cur = root.val + left + right;
        ans[0] = Math.max(ans[0], cur);
        return root.val + Math.max(left, right);
    }
}