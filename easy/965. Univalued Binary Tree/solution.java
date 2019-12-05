/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        
        int val = root.val;
        return preorder(val, root);
    }
    private boolean preorder(int val, TreeNode root) {
        
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return preorder(val, root.left) && preorder(val, root.right);
    }
}