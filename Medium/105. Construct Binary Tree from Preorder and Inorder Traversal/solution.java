
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = map.get(root.val);
        int numLeft = index - inLeft;
        
        root.left = build(preorder, preLeft + 1, preLeft + numLeft, inorder, inLeft, index -1, map);
        root.right = build(preorder, preLeft + numLeft + 1, preRight, inorder, index + 1, inRight, map);
        return root;
    }
}

/**
 * solution 2
 */


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preLeft, int[] inorder, int inLeft, int inRight) {
        
        if (preLeft > preorder.length - 1 || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        int numLeft = index - inLeft;
        root.left = build(preorder, preLeft + 1, inorder, inLeft, index - 1);
        root.right = build(preorder, preLeft + numLeft + 1, inorder, index + 1, inRight);
        return root;
    }
}