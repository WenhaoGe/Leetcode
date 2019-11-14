/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfshelper(root, ans);
        return ans;
    }

    private void dfshelper(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }
        dfshelper(root.left, ans);
        ans.add(root.val);
        dfshelper(root.right, ans);
    }
}

/**
 * solution 2
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ans;
        }
        pushAllLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            pushAllLeft(stack, node.right);
        }
        return ans;

    }

    private void pushAllLeft(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}