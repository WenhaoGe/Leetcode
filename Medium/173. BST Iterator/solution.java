/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    private Queue<TreeNode> q;
    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        dfs(root, q);
    }
    
    /** @return the next smallest number */
    public int next() {
        return q.poll().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }
    private void dfs(TreeNode root, Queue<TreeNode> q) {
        if(root == null) {return;}
        dfs(root.left, q);
        q.offer(root);
        dfs(root.right, q);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */