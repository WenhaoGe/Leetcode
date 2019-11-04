class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        dfsLeft(root.left, ans);
        dfsLeaves(root.left, ans);
        dfsLeaves(root.right, ans);
        dfsRight(root.right, ans);
        return ans;
    }

    private void dfsLeft(TreeNode root, List<Integer> ans) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        ans.add(root.val);
        if (root.left == null) {
            dfsLeft(root.right, ans);
        } else {
            dfsLeft(root.left, ans);
        }

    }

    private void dfsRight(TreeNode root, List<Integer> ans) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        if (root.right == null) {
            dfsRight(root.left, ans);
        } else {
            dfsRight(root.right, ans);
        }
        ans.add(root.val);
    }

    private void dfsLeaves(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }
        dfsLeaves(root.left, ans);
        dfsLeaves(root.right, ans);
    }
}