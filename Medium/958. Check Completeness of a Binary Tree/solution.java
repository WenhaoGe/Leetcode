/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
  * TC: O(n)
  * SC:O (n)
  */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isComplete = false;
        while (!q.isEmpty()) {
            
            int s = q.size();
            for (int i = 0; i < s; ++i) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    if (!isComplete) {
                        q.offer(node.left);
                    } else {
                        return false;
                    }
                } else {
                    isComplete = true;
                }
                if (node.right != null) {
                    if (!isComplete) {
                        q.offer(node.right);
                    } else {
                        return false;
                    }
                } else {
                    isComplete = true;
                }
            }
        }
        return true;
    }
}