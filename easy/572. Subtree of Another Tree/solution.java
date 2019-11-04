/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        traversal(s, sb1);
        traversal(t, sb2);
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        int len = s2.length();
        for (int i = 0; i <= s1.length() - len; i++) {
            if (s1.substring(i, i + len).equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public void traversal(TreeNode s, StringBuilder sb) {

        if (s != null) {
            sb.append("#" + s.val);
        }
        if (s.left != null) {
            traversal(s.left, sb);
        }
        if (s.right != null) {
            traversal(s.right, sb);
        } else {
            sb.append("#lnull");
            sb.append("#rnull");
        }
    }
}