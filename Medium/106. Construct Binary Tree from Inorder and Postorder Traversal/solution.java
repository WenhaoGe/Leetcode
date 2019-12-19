
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int last = postorder.length - 1;
        return build(inorder, postorder, last, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int postRight, int inLeft, int inRight) {
        
        if (postRight > postorder.length - 1 || inLeft > inRight) {
            return null;
        } 
        TreeNode root = new TreeNode(postorder[postRight]);
        int index = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        int numsRight = inRight - index;
        root.left = build(inorder, postorder, postRight - numsRight - 1, inLeft, index - 1);
        root.right = build(inorder, postorder, postRight - 1, index + 1, inRight);
        return root;
    }
}