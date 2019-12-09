
class Solution {
    public void recoverTree(TreeNode root) {
        
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        int first = 0;
        int second = 0;
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                count++;
                if (first == 0) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }
        if (count == 1) {
            modify(root, list.get(first - 1), list.get(first), 2);
        } else {
            modify(root, list.get(first - 1), list.get(second), 2);
        }
    }
    private void modify(TreeNode root, int val1, int val2, int count) {
        
        if (root == null) {
            return;
        }
        if (root.val == val1 || root.val == val2) {
            
            root.val = root.val == val1 ? val2 : val1;
            if (--count == 0) {
                return;
            }
            
        } 
        modify(root.left, val1, val2, count);
        
        modify(root.right, val1, val2, count);
        
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