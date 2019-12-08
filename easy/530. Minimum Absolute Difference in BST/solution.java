
/**
 * use in order traversal to get all the values and try to find out the minimum one. 
 */

class Solution {
    public int getMinimumDifference(TreeNode root) {
        
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        traversal(list, root);
        int len = list.size();
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            ans = Math.min(ans, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return ans;
    }
    
    private void traversal(List<Integer> list, TreeNode root) {
        
        if (root == null) {
            return;
        }
        traversal(list, root.left);
        list.add(root.val);
        traversal(list, root.right);
    }
}