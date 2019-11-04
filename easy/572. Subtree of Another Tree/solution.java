/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// Solution 1:
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

// Solution 2:
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        return traversal(s, t);
    }

    private boolean equal(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return equal(node1.left, node2.left) && equal(node1.right, node2.right);
        } else {
            return false;
        }
    }

    public boolean traversal(TreeNode s, TreeNode t) {

        return s != null && (equal(s, t) || traversal(s.left, t) || traversal(s.right, t));

    }
}

// Solution 3
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}