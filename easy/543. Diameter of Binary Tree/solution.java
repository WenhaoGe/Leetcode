/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        int[] res = { 0 };
        int i = traversal(root, res);
        return res[0];
    }

    private int traversal(TreeNode root, int[] res) {

        if (root == null) {
            return 0;
        }
        int left = traversal(root.left, res);
        int right = traversal(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right) + 1;
    }

}