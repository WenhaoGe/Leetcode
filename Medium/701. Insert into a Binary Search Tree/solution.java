
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return root;
        }
        inorder(list, root);
        list.add(val);
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        return build(list, left, right);
    }
    
    private TreeNode build(List<Integer> list, int left, int right) {
        
        if (left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode newroot = new TreeNode(list.get(mid));
            newroot.left = build(list, left, mid - 1);
            newroot.right = build(list, mid + 1, right);
            return newroot;
        } else {
            return null;
        }
        
    }
    private void inorder(List<Integer> list, TreeNode root) {
        
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}